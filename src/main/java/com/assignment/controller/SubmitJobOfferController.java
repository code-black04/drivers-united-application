package com.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.assignment.dtos.JobOfferDto;
import com.assignment.service.SubmitJobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<JobOfferDto> submitJobOffer(@PathVariable Long jobId, @RequestBody JobOfferDto jobOfferDto) {
        // Assuming the jobOfferDto's jobOfferId is the source of truth
        if (!jobId.equals(jobOfferDto.getJobOfferId())) {
            return ResponseEntity.badRequest().body(null);
        }

        JobOfferDto submittedJobOfferDto = submitJobOfferService.submitJobOffer(jobOfferDto);
        return ResponseEntity.created(URI.create("/api/jobs/" + submittedJobOfferDto.getJobOfferId())).body(submittedJobOfferDto);
    }
}
