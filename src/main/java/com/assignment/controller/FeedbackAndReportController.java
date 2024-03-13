package com.assignment.controller;

import com.assignment.dtos.FeedbackDto;
import com.assignment.service.FeedbackAndReportService;
import io.swagger.annotations.Api;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.assignment.CommonUtils.extractUsername;

@RestController
@RequestMapping(path = "/f")
@Api
public class FeedbackAndReportController {
        @Autowired
        private FeedbackAndReportService feedbackAndReportService;

        @PostMapping(path = "/jobs/feedback")
        public ResponseEntity<FeedbackDto> createFeedbackAndReport(
                @RequestBody(required = true) FeedbackDto feedback,
                @RequestHeader(required = true) String Authorization
        ) throws NotFoundException {
                String token = Authorization.substring(6);
                String driverId = extractUsername(token);
                FeedbackDto requestedFeedback = feedbackAndReportService.createFeedbackAndReport(feedback, driverId);
                return new ResponseEntity<>(requestedFeedback, HttpStatus.CREATED);
        }
}
