package com.assignment.service;

import com.assignment.dtos.DeliveryJobOfferDTO;
import com.assignment.entity.DeliveryJobOfferEntity;
import com.assignment.mapper.DeliveryJobOfferDtoEntityMapper;
import com.assignment.repository.DeliveryJobOfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvailableJobService {
    private static final Logger logger = LoggerFactory.getLogger(AvailableJobService.class);

    @Autowired
    private DeliveryJobOfferRepository jobOfferRepository;

    @Autowired
    private DeliveryJobOfferDtoEntityMapper jobOfferDtoEntityMapper;

    public List<DeliveryJobOfferDTO> getAllAvailableJobOffer() {
        try {
            List<DeliveryJobOfferEntity> jobOfferEntityList = jobOfferRepository.findAll();
            List<DeliveryJobOfferDTO> jobOfferDTOList = new ArrayList<>();
            for (DeliveryJobOfferEntity jobOfferEntity : jobOfferEntityList) {
                DeliveryJobOfferDTO jobOfferDTO = jobOfferDtoEntityMapper.convertToDeliveryJobOfferDto(jobOfferEntity);
                jobOfferDTOList.add(jobOfferDTO);
            }

            return jobOfferDTOList;

        } catch (Exception exception) {
            System.out.println("Entity not found");
            return null;
        }
    }
}