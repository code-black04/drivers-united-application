package com.assignment.service;

import com.assignment.dtos.FeedbackDto;
import com.assignment.entity.DriverEntity;
import com.assignment.entity.FeedbackEntity;
import com.assignment.mapper.FeedbackDtoEntityMapper;
import com.assignment.repository.DriverRepository;
import com.assignment.repository.FeedbackRepository;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackAndReportService {

    private Logger logger = LoggerFactory.getLogger(FeedbackAndReportService.class);

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private FeedbackDtoEntityMapper feedbackDtoEntityMapper;

    public FeedbackDto createFeedbackAndReport(FeedbackDto requestedFeedback, String driverId) throws NotFoundException {
        if (driverRepository.getById(driverId) != null) {
            requestedFeedback.getDriver().setDriverId(driverId);
            logger.info("FeedbackService : createFeedBack {}", requestedFeedback);
            FeedbackEntity feedbackEntity;
            feedbackEntity = feedbackDtoEntityMapper.convertToFeedbackEntity(requestedFeedback);
            feedbackRepository.save(feedbackEntity);
            return requestedFeedback;
        }  else
            return null;
    }
}
