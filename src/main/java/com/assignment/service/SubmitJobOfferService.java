package com.assignment.service;

import com.assignment.dtos.JobOfferDto;
import com.assignment.dtos.PaymentDetailsDto;
import com.assignment.entity.JobOfferEntity;
import com.assignment.entity.PaymentDetailsEntity;
import com.assignment.mapper.JobOfferDtoEntityMapper;
import com.assignment.mapper.PaymentDetailsDtoEntityMapper;
import com.assignment.repository.JobOfferRepository;
import com.assignment.repository.PaymentDetailsRepository;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SubmitJobOfferService {

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private PaymentDetailsRepository paymentDetailsRepository;

    @Autowired
    private JobOfferDtoEntityMapper jobOfferDtoEntityMapper;

    @Autowired
    private PaymentDetailsDtoEntityMapper paymentDetailsDtoEntityMapper;

    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;

    private final String GOOGLE_MAPS_DIRECTION_ENDPOINT = "https://maps.googleapis.com/maps/api/directions/json";

    public PaymentDetailsDto submitJobOffer(JobOfferDto jobOfferDto) {
        // Convert DTO to Entity
        JobOfferEntity jobOfferEntity = jobOfferDtoEntityMapper.convertToJobOfferEntity(jobOfferDto);

        // Save job offer to repository
        jobOfferEntity = jobOfferRepository.save(jobOfferEntity);

        // Calculate payment based on route
        PaymentDetailsDto paymentDetailsDto = calculatePayment(jobOfferEntity);

        // Save payment details to repository
        PaymentDetailsEntity paymentDetailsEntity = paymentDetailsDtoEntityMapper.convertToPaymentDetailsEntity(paymentDetailsDto);
        paymentDetailsEntity = paymentDetailsRepository.save(paymentDetailsEntity);

        return paymentDetailsDto;
    }

    private PaymentDetailsDto calculatePayment(JobOfferEntity jobOfferEntity) {
        // Retrieve origin and destination from job offer entity
        String origin = jobOfferEntity.getLocationDetails().getPickUpLocationCoordinates();
        String destination = jobOfferEntity.getLocationDetails().getDropOffLocationCoordinates();

        // Call Google Maps API to get directions
        DirectionsResult directionsResult = getDirections(origin, destination);

        // Calculate payment based on distance, assuming $0.5 per kilometer
        double distanceInKm = directionsResult.routes[0].legs[0].distance.inMeters / 1000.0;
        float paymentAmount = (float) (distanceInKm * 0.5);


        // Create PaymentDetailsDto object
        PaymentDetailsDto paymentDetailsDto = new PaymentDetailsDto();
        paymentDetailsDto.getJobOffer(jobOfferEntity);
        paymentDetailsDto.setPaymentAmount(paymentAmount);

        return paymentDetailsDto;
    }

    private DirectionsResult getDirections(String origin, String destination) { 
        String url = String.format("%s?origin=%s&destination=%s&key=%s",
                GOOGLE_MAPS_DIRECTION_ENDPOINT, origin, destination, googleMapsApiKey);

        try {
            // Create a GeoApiContext with your API key
            GeoApiContext context = new GeoApiContext.Builder().apiKey(googleMapsApiKey).build();

            // Make a directions API request
            return DirectionsApi.newRequest(context)
                    .mode(TravelMode.DRIVING)
                    .origin(origin)
                    .destination(destination)
                    .await();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
