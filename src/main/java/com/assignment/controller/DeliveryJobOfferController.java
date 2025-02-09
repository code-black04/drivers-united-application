package com.assignment.controller;

import com.assignment.dtos.DeliveryJobOfferDTO;
import com.assignment.service.AvailableJobService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/delivery")
@Api
public class DeliveryJobOfferController {
    @Autowired
    private AvailableJobService availableJobService;

    @GetMapping(path = "/jobs")
    public ResponseEntity<List<DeliveryJobOfferDTO>> getAvailableJobOffers() {
        List<DeliveryJobOfferDTO> deliveryJobOfferDTOList = availableJobService.getAllAvailableJobOffer();
        if (deliveryJobOfferDTOList != null)
            return new ResponseEntity<>(deliveryJobOfferDTOList, HttpStatus.OK);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}