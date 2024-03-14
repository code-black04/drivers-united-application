package com.assignment.service;

import com.assignment.dtos.DeliveryJobOfferDTO;
import com.assignment.dtos.JobOfferDto;
import com.assignment.entity.DeliveryJobOfferEntity;
import com.assignment.entity.JobOfferEntity;
import com.assignment.mapper.DeliveryJobOfferDtoEntityMapper;
import com.assignment.mapper.JobOfferDtoEntityMapper;
import com.assignment.repository.DeliveryJobOfferRepository;
import com.assignment.repository.JobOfferRepository;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailableJobService {
    private static final Logger logger = LoggerFactory.getLogger(AvailableJobService.class);

    @Autowired
    private DeliveryJobOfferRepository jobOfferRepository;

    @Autowired
    private DeliveryJobOfferDtoEntityMapper jobOfferDtoEntityMapper;

    public DeliveryJobOfferDTO getAvailableJobOfferById(String jobOfferId, String driverId) {
        logger.info("AvailableJobService: getAvailableJobOfferById {}", jobOfferId);
        DeliveryJobOfferEntity jobOfferEntity = jobOfferRepository.getById(Long.valueOf(jobOfferId));
        if (driverId.equals(jobOfferEntity.getDriverId()) && driverId == jobOfferEntity.getDriverId().toString()) {
            DeliveryJobOfferDTO jobOfferDto = null;
            if (jobOfferEntity != null)
                jobOfferDto = jobOfferDtoEntityMapper.convertToDeliveryJobOfferDto(jobOfferEntity);
            return jobOfferDto;
        } else
            return null;
    }
}