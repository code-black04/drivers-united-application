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
    private ResponseEntity<JobOfferDto> saveJobOffer(@RequestBody JobOfferDto jobOffer, @RequestParam String driverId) throws Exception {
        try {
            JobOfferDto jobOfferDto = enterJobOfferService.enterJobOffer(jobOffer, driverId);
            if(jobOfferDto == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(jobOffer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
