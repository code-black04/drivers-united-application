package com.assignment.mapper;

import com.assignment.dtos.JobOfferDto;
import com.assignment.entity.JobOfferEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobOfferDtoEntityMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    private JobOfferDto convertToJobOfferDto(JobOfferEntity jobOfferEntity) {
        JobOfferDto jobOfferDto = modelMapper.map(jobOfferEntity, JobOfferDto.class);
        return jobOfferDto;
    }

    private JobOfferEntity convertToJobOfferEntity(JobOfferDto jobOfferDto) {
        JobOfferEntity jobOfferEntity = modelMapper.map(jobOfferDto, JobOfferEntity.class);
        return jobOfferEntity;
    }
}
