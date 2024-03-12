package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.dtos.JobOfferDto;
import com.assignment.service.EnterJobOfferService;

@RestController
public class EnterJobOffersController {
    @Autowired

    EnterJobOfferService enterJobOfferService;
    @PostMapping("/jobs")
    private long saveJobOffer(@RequestBody JobOfferDto jobOffer) {
        enterJobOfferService.enterJobOffer(jobOffer);
        return jobOffer.getJobOfferId();
    }
    
}
