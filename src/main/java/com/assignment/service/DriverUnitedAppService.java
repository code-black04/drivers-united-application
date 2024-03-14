package com.assignment.service;

import com.assignment.dtos.*;
import com.assignment.entity.DriverEntity;
import com.assignment.entity.FeedbackEntity;
import com.assignment.entity.JobOfferEntity;
import com.assignment.enums.JobOfferStatus;
import com.assignment.enums.PaymentStatus;
import com.assignment.mapper.DriverDtoEntityMapper;
import com.assignment.mapper.FeedbackDtoEntityMapper;
import com.assignment.mapper.JobOfferDtoEntityMapper;
import com.assignment.repository.DriverRepository;
import com.assignment.repository.FeedbackRepository;
import com.assignment.repository.JobOfferRepository;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class DriverUnitedAppService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private JobOfferDtoEntityMapper jobOfferDtoEntityMapper;

    @Autowired
    private DriverDtoEntityMapper driverDtoEntityMapper;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackDtoEntityMapper feedbackDtoEntityMapper;

    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;

    @Value("${fare.base}")
    private float baseFare;

    @Value("${fare.costPerKilometer}")
    private float costPerKilometer;


    public JobOfferDto enterJobOffer(JobOfferDto jobOfferDto, String driverId) throws Exception {
        if (!driverRepository.existsById(driverId)) return null;
        DriverEntity driverEntity = driverRepository.getById(driverId);
        DriverDto driverDto = driverDtoEntityMapper.convertToDriverDto(driverEntity);
        jobOfferDto.setDriver(driverDto);
        jobOfferDto.setJobOfferStatus(JobOfferStatus.IN_PROGRESS);
        JobOfferEntity jobOfferEntity = jobOfferDtoEntityMapper.convertToJobOfferEntity(jobOfferDto);
        jobOfferRepository.save(jobOfferEntity);
        return jobOfferDto;
    }

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
            long durationInSeconds = directionsResult.routes[0].legs[0].duration.inSeconds;
            float paymentAmount = calculatePaymentAmount(distanceInMeters);

            // Set payment details
            PaymentDetailsDto paymentDetails = new PaymentDetailsDto();
            paymentDetails.setPaymentAmount(paymentAmount);
            paymentDetails.setPaymentStatus(PaymentStatus.COMPLETED);
            jobOfferDto.setPaymentDetails(paymentDetails);

            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime estimatedArrivalTime = currentTime.plusSeconds(durationInSeconds);

            // Set travel time details
            TravelTimeDetailsDto travelTimeDetails = new TravelTimeDetailsDto();
            travelTimeDetails.setDate(currentTime);
            travelTimeDetails.setTime(estimatedArrivalTime);
            travelTimeDetails.setDurationInSeconds(durationInSeconds);

            // Set route and time details
            RouteAndTimeDetailsDto routeAndTimeDetails = new RouteAndTimeDetailsDto();
            routeAndTimeDetails.setTravelTimeDetails(travelTimeDetails);

            jobOfferDto.setRouteAndTimeDetails(routeAndTimeDetails);

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

        return new String[]{Double.toString(randomLat), Double.toString(randomLng)};
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

    public FeedbackDto createFeedbackAndReport(FeedbackDto requestedFeedback, String driverId) throws NotFoundException {
        if (driverRepository.existsById(driverId)) {
            requestedFeedback.getDriver().setDriverId(driverId);
            FeedbackEntity feedbackEntity;
            feedbackEntity = feedbackDtoEntityMapper.convertToFeedbackEntity(requestedFeedback);
            feedbackRepository.save(feedbackEntity);
            return requestedFeedback;
        } else
            return null;
    }

}
