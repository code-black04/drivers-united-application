package com.assignment.controller;

import com.assignment.dtos.DeliveryJobOfferDTO;
import com.assignment.dtos.JobOfferDto;
import com.assignment.service.AvailableJobService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/a")
public class AvailableJobController {
    @Autowired
    private AvailableJobService availableJobService;

    @GetMapping(path = "/jobs")
    public ResponseEntity<DeliveryJobOfferDTO> getAvailableJobOffers(
            @RequestParam(required = true, value = "jobOfferId") String jobOfferId,
            @RequestParam(required = true, value="driverId") String driverId
    ) {
        DeliveryJobOfferDTO deliveryJobOfferDTO = availableJobService.getAvailableJobOfferById(jobOfferId , driverId);
        if (deliveryJobOfferDTO != null)
            return new ResponseEntity<>(deliveryJobOfferDTO, HttpStatus.ACCEPTED);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}