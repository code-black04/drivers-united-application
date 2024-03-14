package com.assignment.mapper;

import com.assignment.dtos.DriverDto;
import com.assignment.entity.DriverEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DriverDtoEntityMapper {

    @Autowired
    private ModelMapper modelMapper;

    public DriverDto convertToDriverDto(DriverEntity driverEntity) {
        DriverDto driverDto = modelMapper.map(driverEntity, DriverDto.class);
        return driverDto;
    }

    public DriverEntity convertToDriverEntity(DriverDto driverDto) {
        DriverEntity driverEntity = modelMapper.map(driverDto, DriverEntity.class);
        return driverEntity;
    }

    public List<DriverEntity> convertToDriverEntityList(List<DriverDto> driverDtoList) {
        List<DriverEntity> driverEntityList = mapList(driverDtoList, DriverEntity.class);
        return driverEntityList;
    }

    public List<DriverDto> convertToDriverDtoList(List<DriverEntity> driverEntityList) {
        List<DriverDto> driverDtoList = mapList(driverEntityList, DriverDto.class);
        return driverDtoList;
    }

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }


}
