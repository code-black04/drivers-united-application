package com.assignment.mapper;

import com.assignment.dtos.LocationDetailsDto;
import com.assignment.entity.LocationDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationDetailsDtoEntityMapper {

    @Autowired
    private ModelMapper modelMapper;

    public LocationDetailsDto convertToLocationDetailsDto(LocationDetails locationDetailsEntity) {
        LocationDetailsDto locationDetailsDto = modelMapper.map(locationDetailsEntity, LocationDetailsDto.class);
        return locationDetailsDto;
    }

    public LocationDetails convertToLocationDetailsEntity(LocationDetailsDto locationDetailsDto) {
        LocationDetails locationDetailsEntity = modelMapper.map(locationDetailsDto, LocationDetails.class);
        return locationDetailsEntity;
    }
    
}
