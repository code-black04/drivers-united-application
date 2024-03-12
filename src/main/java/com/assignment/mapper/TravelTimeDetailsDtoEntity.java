package com.assignment.mapper;

import com.assignment.dtos.TravelTimeDetailsDto;
import com.assignment.entity.TravelTimeDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TravelTimeDetailsDtoEntity {

    @Autowired
    private ModelMapper modelMapper;

    public TravelTimeDetailsDto convertToTravelTimeDetailsDto(TravelTimeDetails travelTimeDetailsEntity) {
        TravelTimeDetailsDto travelTimeDetailsDto = modelMapper.map(travelTimeDetailsEntity, TravelTimeDetailsDto.class);
        return travelTimeDetailsDto;
    }

    public TravelTimeDetails convertToTravelTimeDetailsEntity(TravelTimeDetailsDto travelTimeDetailsDto) {
        TravelTimeDetails travelTimeDetailsEntity = modelMapper.map(travelTimeDetailsDto, TravelTimeDetails.class);
        return travelTimeDetailsEntity;
    }
    
}
