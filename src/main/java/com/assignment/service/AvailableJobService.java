package com.assignment.service;

import com.assignment.dtos.JobOfferDto;
import com.assignment.entity.JobOfferEntity;
import com.assignment.mapper.JobOfferDtoEntityMapper;
import com.assignment.repository.JobOfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailableJobService {
    private static final Logger logger = LoggerFactory.getLogger(AvailableJobService.class);

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private JobOfferDtoEntityMapper jobOfferDtoEntityMapper;

    public JobOfferDto getAvailableJobOfferById(long jobOfferId) {
        logger.info("AvailableJobService: getAvailableJobOfferById {}", jobOfferId);

        JobOfferEntity jobOfferEntity = jobOfferRepository.findById(jobOfferId).orElse(null);
        JobOfferDto jobOfferDto = null;

        if (jobOfferEntity != null) {
            jobOfferDto = jobOfferDtoEntityMapper.convertToJobOfferDto(jobOfferEntity);
        }

        return jobOfferDto;
    }
}