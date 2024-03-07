package com.assignment.mapper;

import com.assignment.dtos.JobConfirmationDto;
import com.assignment.entity.JobConfirmationEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobConfirmationDtoEntityMapper {

    @Autowired
    private ModelMapper modelMapper;

    private JobConfirmationDto convertToJobConfirmationDto(JobConfirmationEntity jobConfirmationEntity) {
        JobConfirmationDto jobConfirmationDto = modelMapper.map(jobConfirmationEntity, JobConfirmationDto.class);
        return jobConfirmationDto;
    }

    private JobConfirmationEntity convertToJobConfirmationEntity(JobConfirmationDto jobConfirmationDto) {
        JobConfirmationEntity jobConfirmationEntity = modelMapper.map(jobConfirmationDto, JobConfirmationEntity.class);
        return jobConfirmationEntity;
    }

}