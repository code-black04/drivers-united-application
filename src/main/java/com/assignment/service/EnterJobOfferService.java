package com.assignment.service;

import com.assignment.dtos.JobOfferDto;
import com.assignment.entity.JobOfferEntity;
import com.assignment.mapper.JobOfferDtoEntityMapper;
import com.assignment.repository.JobOfferRepository;
import org.springframework.stereotype.Service;

@Service
public class EnterJobOfferService {

    private JobOfferRepository jobOfferRepository;
    private JobOfferDtoEntityMapper jobOfferDtoEntityMapper;

    public EnterJobOfferService(JobOfferRepository jobOfferRepository, JobOfferDtoEntityMapper jobOfferDtoEntityMapper) {
        this.jobOfferRepository = jobOfferRepository;
        this.jobOfferDtoEntityMapper = jobOfferDtoEntityMapper;
    }

    public void enterJobOffer(JobOfferDto jobOfferDto) {
        JobOfferEntity jobOfferEntity = jobOfferDtoEntityMapper.convertToJobOfferEntity(jobOfferDto);
        System.out.println(jobOfferEntity.getJobOfferDescription());
        jobOfferRepository.save(jobOfferEntity);
    }
    
}
