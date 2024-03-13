package com.assignment.service;

import com.assignment.dtos.DriverDto;
import com.assignment.dtos.JobOfferDto;
import com.assignment.entity.JobOfferEntity;
import com.assignment.entity.DriverEntity;
import com.assignment.mapper.JobOfferDtoEntityMapper;
import com.assignment.mapper.DriverDtoEntityMapper;
import com.assignment.repository.JobOfferRepository;
import com.assignment.repository.DriverRepository;
import com.assignment.enums.JobOfferStatus;
import org.springframework.stereotype.Service;

@Service
public class EnterJobOfferService {

    private DriverRepository driverRepository;
    private JobOfferRepository jobOfferRepository;
    private JobOfferDtoEntityMapper jobOfferDtoEntityMapper;
    private DriverDtoEntityMapper driverDtoEntityMapper;

    public EnterJobOfferService(JobOfferRepository jobOfferRepository, JobOfferDtoEntityMapper jobOfferDtoEntityMapper, DriverRepository driverRepository, DriverDtoEntityMapper driverDtoEntityMapper) {
        this.jobOfferRepository = jobOfferRepository;
        this.jobOfferDtoEntityMapper = jobOfferDtoEntityMapper;
        this.driverRepository = driverRepository;
        this.driverDtoEntityMapper = driverDtoEntityMapper;
    }

    public JobOfferDto enterJobOffer(JobOfferDto jobOfferDto, String driverId) throws Exception {
        if(!driverRepository.existsById(driverId)) return null;
        DriverEntity driverEntity = driverRepository.getById(driverId);
        DriverDto driverDto = driverDtoEntityMapper.convertToDriverDto(driverEntity);
        jobOfferDto.setDriver(driverDto);
        jobOfferDto.setJobOfferStatus(JobOfferStatus.IN_PROGRESS);
        JobOfferEntity jobOfferEntity = jobOfferDtoEntityMapper.convertToJobOfferEntity(jobOfferDto); 
        jobOfferRepository.save(jobOfferEntity);
        return jobOfferDto;
    }
    
}
