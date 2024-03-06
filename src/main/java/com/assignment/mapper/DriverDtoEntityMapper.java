package com.assignment.mapper;

import com.assignment.dtos.DriverDto;
import com.assignment.entity.DriverEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverDtoEntityMapper {

    @Autowired
    private ModelMapper modelMapper;

    private DriverDto convertToDriverDto(DriverEntity driverEntity) {
        DriverDto driverDto = modelMapper.map(driverEntity, DriverDto.class);
        return driverDto;
    }

    private DriverEntity convertToDriverEntity(DriverDto driverDto) {
        DriverEntity driverEntity = modelMapper.map(driverDto, DriverEntity.class);
        return driverEntity;
    }

}
