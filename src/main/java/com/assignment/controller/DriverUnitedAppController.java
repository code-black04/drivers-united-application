package com.assignment.controller;

import com.assignment.dtos.FeedbackDto;
import com.assignment.dtos.JobOfferDto;
import com.assignment.service.DriverUnitedAppService;
import io.swagger.annotations.Api;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.assignment.CommonUtils.extractUsername;

@RestController
@RequestMapping(path = "/driver")
@Api
public class DriverUnitedAppController {

    @Autowired
    DriverUnitedAppService driverUnitedAppService;

    /**
     * @author Jesus Ormaza Espin
     */
    @PostMapping(path = "/jobs/enter")
    private ResponseEntity<JobOfferDto> saveJobOffer(@RequestBody JobOfferDto jobOffer, @RequestParam String driverId) throws Exception {
        try {
            JobOfferDto jobOfferDto = driverUnitedAppService.enterJobOffer(jobOffer, driverId);
            if (jobOfferDto == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(jobOffer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @author Abhishek Roy
     */
    @PostMapping(path = "/jobs/submit")
    public ResponseEntity<JobOfferDto> submitJobOffer(@RequestBody JobOfferDto jobOfferDto, @RequestParam Long jobId) throws Exception {
        try {
            JobOfferDto submittedJobOfferDto = driverUnitedAppService.submitJobOffer(jobOfferDto);
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

    /**
     * @author Purnima Maheshwari
     */
    @PostMapping(path = "/jobs/feedback")
    public ResponseEntity<FeedbackDto> createFeedbackAndReport(
            @RequestBody(required = true) FeedbackDto feedback
    ) throws NotFoundException {
        FeedbackDto requestedFeedback = driverUnitedAppService.createFeedbackAndReport(feedback);
        return new ResponseEntity<>(requestedFeedback, HttpStatus.CREATED);
    }

    /**
     * @author Soumik Datta
     */
    @PutMapping(path = "/jobs/confirm")
    public ResponseEntity<JobOfferDto> confirmJobOffer(@RequestParam String jobId, @RequestParam String driverId, @RequestParam String jobOfferStatus) {
        if (jobId == null || driverId == null || jobOfferStatus == null) {
            return ResponseEntity.badRequest().body(null);
        }

        JobOfferDto jobOfferDto = driverUnitedAppService.updateJobOfferById(jobId, driverId, jobOfferStatus);

        return new ResponseEntity<>(jobOfferDto, HttpStatus.OK);
    }

}
