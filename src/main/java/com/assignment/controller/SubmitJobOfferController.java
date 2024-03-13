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
@RequestMapping(path = "/jobs")
public class SubmitJobOfferController {

    private final SubmitJobOfferService submitJobOfferService;

    @Autowired
    public SubmitJobOfferController(SubmitJobOfferService submitJobOfferService) {
        this.submitJobOfferService = submitJobOfferService;
    }

    @PostMapping
    public ResponseEntity<JobOfferDto> submitJobOffer(@RequestBody JobOfferDto jobOfferDto) throws Exception {

        try {
            JobOfferDto submittedJobOfferDto = submitJobOfferService.submitJobOffer(jobOfferDto);
            if (submittedJobOfferDto == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(submittedJobOfferDto, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception details here
            throw new Exception("Failed to submit job offer: ", e);
        }
    }
}
