package com.assignment.service;

import com.assignment.dtos.JobOfferDto;
import com.assignment.dtos.PaymentDetailsDto;
import com.assignment.entity.JobOfferEntity;
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
        calculatePaymentAndUpdateJobOfferDto(jobOfferDto);

        jobOfferEntity = jobOfferDtoEntityMapper.convertToJobOfferEntity(jobOfferDto);
        jobOfferRepository.save(jobOfferEntity);

        return jobOfferDto;
    }

    private void calculatePaymentAndUpdateJobOfferDto(JobOfferDto jobOfferDto) throws ApiException, InterruptedException, IOException {
        String origin = jobOfferDto.getRouteAndTimeDetails().getLocation().getPickUpLocationCoordinates();
        String destination = jobOfferDto.getRouteAndTimeDetails().getLocation().getDropOffLocationCoordinates();

        DirectionsResult directionsResult = getDirections(origin, destination);

        if (directionsResult != null && directionsResult.routes.length > 0) {
            double distanceInMeters = directionsResult.routes[0].legs[0].distance.inMeters;
            float paymentAmount = calculatePaymentAmount(distanceInMeters);

            if (jobOfferDto.getPaymentDetails() == null) {
                jobOfferDto.setPaymentDetails(new PaymentDetailsDto());
            }
            jobOfferDto.getPaymentDetails().setPaymentAmount(paymentAmount);
            jobOfferDto.getPaymentDetails().setPaymentStatus(com.assignment.enums.PaymentStatus.INITIALIZE);
        } else {
            throw new RuntimeException("Failed to calculate route.");
        }
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
