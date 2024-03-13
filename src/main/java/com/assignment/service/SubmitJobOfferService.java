package com.assignment.service;

import com.assignment.dtos.JobOfferDto;
import com.assignment.dtos.PaymentDetailsDto;
import com.assignment.entity.JobOfferEntity;
import com.assignment.enums.PaymentStatus;
import com.assignment.mapper.JobOfferDtoEntityMapper;
import com.assignment.repository.JobOfferRepository;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Random;

@Service
public class SubmitJobOfferService {

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private JobOfferDtoEntityMapper jobOfferDtoEntityMapper;

    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;

    @Value("${fare.base}")
    private float baseFare;

    @Value("${fare.costPerKilometer}")
    private float costPerKilometer;

    public JobOfferDto submitJobOffer(JobOfferDto jobOfferDto) throws Exception {
        // Use mapper to convert DTO to Entity
        JobOfferEntity jobOfferEntity = jobOfferDtoEntityMapper.convertToJobOfferEntity(jobOfferDto);

        // Save the entity
        jobOfferEntity = jobOfferRepository.save(jobOfferEntity);

        // Update the DTO with route and payment calculation
        jobOfferDto = calculatePaymentAndUpdateJobOfferDto(jobOfferDto);

        jobOfferEntity = jobOfferDtoEntityMapper.convertToJobOfferEntity(jobOfferDto);
        jobOfferRepository.save(jobOfferEntity);

        return jobOfferDto;
    }

    private JobOfferDto calculatePaymentAndUpdateJobOfferDto(JobOfferDto jobOfferDto) throws ApiException, InterruptedException, IOException {
        // Coordinates for Leicester and London
        double leicesterLat = 52.6369;
        double leicesterLng = -1.1398;
        double londonLat = 51.5074;
        double londonLng = -0.1278;

        // Generate random coordinates for Leicester and London
        String[] originCoords = generateRandomCoordinates(leicesterLat, leicesterLng, 5.0);
        String[] destinationCoords = generateRandomCoordinates(londonLat, londonLng, 5.0);

        String origin = String.join(",", originCoords); // Leicester coordinates
        String destination = String.join(",", destinationCoords); // London coordinates

        DirectionsResult directionsResult = getDirections(origin, destination);

        if (directionsResult != null && directionsResult.routes.length > 0) {
            double distanceInMeters = directionsResult.routes[0].legs[0].distance.inMeters;
            float paymentAmount = calculatePaymentAmount(distanceInMeters);
//            jobOfferDto.setPaymentDetails(new PaymentDetailsDto());
            jobOfferDto.getPaymentDetails().setPaymentAmount(paymentAmount);
            jobOfferDto.getPaymentDetails().setPaymentStatus(PaymentStatus.COMPLETED);
        } else {
            throw new RuntimeException("Failed to calculate route.");
        }
        return jobOfferDto;
    }

    // Function to generate random coordinates within a short distance from a given center
    private String[] generateRandomCoordinates(double centerLat, double centerLng, double radius) {
        Random random = new Random();

        // Convert radius from kilometers to degrees (approximately)
        double radiusInDegrees = radius / 111.32;

        // Generate random offsets within the radius
        double offsetLat = random.nextDouble() * radiusInDegrees;
        double offsetLng = random.nextDouble() * radiusInDegrees;

        // Apply offsets to the center coordinates
        double randomLat = centerLat + offsetLat;
        double randomLng = centerLng + offsetLng;

        return new String[] {Double.toString(randomLat), Double.toString(randomLng)};
    }


    private DirectionsResult getDirections(String origin, String destination) throws ApiException, InterruptedException, IOException {
        GeoApiContext context = new GeoApiContext.Builder().apiKey(googleMapsApiKey).build();
        return DirectionsApi.newRequest(context)
                .mode(TravelMode.DRIVING)
                .origin(origin)
                .destination(destination)
                .await();
    }

    private float calculatePaymentAmount(double distanceInMeters) {
        return baseFare + (float) (distanceInMeters / 1000.0 * costPerKilometer);
    }
}
