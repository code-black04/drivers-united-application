package com.assignment.controller;

import com.assignment.dtos.FeedbackDto;
import com.assignment.service.FeedbackAndReportService;
import io.swagger.annotations.Api;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Base64;

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

        public static String extractUsername(String base64EncodedString) {
                // Decode the Base64 encoded string
                byte[] decodedBytes = Base64.getDecoder().decode(base64EncodedString);
                String decodedString = new String(decodedBytes);

                // Assuming the format is "username:password", split by ":" and get the username
                String[] parts = decodedString.split(":", 2);
                return parts.length > 0 ? parts[0] : null; // Return the username part
        }

        public static void main(String[] args) {
                String ec = "Basic dXNlcm5hbWU6YWJjMTIz".substring(6);
                System.out.println(extractUsername(ec));
        }
}
