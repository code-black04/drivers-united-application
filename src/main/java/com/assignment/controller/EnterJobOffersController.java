package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.dtos.JobOfferDto;
import com.assignment.service.EnterJobOfferService;

@RestController
public class EnterJobOffersController {
    @Autowired

    EnterJobOfferService enterJobOfferService;
    @PostMapping("/jobs")
    private ResponseEntity<String> saveJobOffer(@RequestBody JobOfferDto jobOffer, @RequestParam String driverId) throws Exception {
        try {
            JobOfferDto jobOfferDto = enterJobOfferService.enterJobOffer(jobOffer, driverId);
            if(jobOfferDto == null) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Driver Not Found\n");
            return ResponseEntity.status(HttpStatus.CREATED).body("Job Offer created successfully\n");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error\n");
        }
    }
    
}
