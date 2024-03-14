package com.assignment.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assignment.dtos.JobOfferDto;
import com.assignment.service.SubmitJobOfferService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path = "/jobs")
public class SubmitJobOfferController {

    private final SubmitJobOfferService submitJobOfferService;

    @Autowired
    public SubmitJobOfferController(SubmitJobOfferService submitJobOfferService) {
        this.submitJobOfferService = submitJobOfferService;
    }

    @PostMapping
    public ResponseEntity<JobOfferDto> submitJobOffer(@RequestBody JobOfferDto jobOfferDto, @RequestParam  Long jobId) throws Exception {

        try {
            JobOfferDto submittedJobOfferDto = submitJobOfferService.submitJobOffer(jobOfferDto);
            if (submittedJobOfferDto == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            jobOfferDto.setJobOfferId(jobId);
            return new ResponseEntity<>(submittedJobOfferDto, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception details here
            throw new Exception("Failed to submit job offer: ", e);
        }
    }
}
