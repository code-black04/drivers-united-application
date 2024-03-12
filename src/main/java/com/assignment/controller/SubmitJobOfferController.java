package com.assignment.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assignment.dtos.JobOfferDto;
import com.assignment.service.SubmitJobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(path = "/api")
public class SubmitJobOfferController {

    private final SubmitJobOfferService submitJobOfferService;

    @Autowired
    public SubmitJobOfferController(SubmitJobOfferService submitJobOfferService) {
        this.submitJobOfferService = submitJobOfferService;
    }

    @PostMapping("/jobs/{jobId}")
    public ResponseEntity<?> submitJobOffer(@PathVariable Long jobId, @RequestBody JobOfferDto jobOfferDto) {
        // Ensures jobId from path matches jobId in the request body, if necessary
        if (!jobId.equals(jobOfferDto.getJobOfferId())) {
            return ResponseEntity.badRequest().build();
        }

        try {
            JobOfferDto submittedJobOfferDto = submitJobOfferService.submitJobOffer(jobOfferDto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(submittedJobOfferDto.getJobOfferId()).toUri();
            return ResponseEntity.created(location).body(submittedJobOfferDto);
        } catch (Exception e) {
            // Log the exception details here
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error submitting job offer: " + e.getMessage());
        }
    }
}
