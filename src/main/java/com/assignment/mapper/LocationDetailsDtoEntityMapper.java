package com.assignment.mapper;

import com.assignment.dtos.LocationDetailsDto;
import com.assignment.entity.LocationDetailsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationDetailsDtoEntityMapper {

    @Autowired
    private ModelMapper modelMapper;

    public LocationDetailsDto convertToLocationDetailsDto(LocationDetailsEntity locationDetailsEntity) {
        LocationDetailsDto locationDetailsDto = modelMapper.map(locationDetailsEntity, LocationDetailsDto.class);
        return locationDetailsDto;
    }

    public LocationDetailsEntity convertToLocationDetailsEntity(LocationDetailsDto locationDetailsDto) {
        LocationDetailsEntity locationDetailsEntity = modelMapper.map(locationDetailsDto, LocationDetailsEntity.class);
        return locationDetailsEntity;
    }

}
