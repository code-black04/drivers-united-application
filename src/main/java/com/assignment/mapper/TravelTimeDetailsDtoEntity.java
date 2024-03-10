package com.assignment.mapper;

import com.assignment.dtos.TravelTimeDetailsDto;
import com.assignment.entity.TravelTimeDetailsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TravelTimeDetailsDtoEntity {

    @Autowired
    private ModelMapper modelMapper;

    public TravelTimeDetailsDto convertToTravelTimeDetailsDto(TravelTimeDetailsEntity travelTimeDetailsEntity) {
        TravelTimeDetailsDto travelTimeDetailsDto = modelMapper.map(travelTimeDetailsEntity, TravelTimeDetailsDto.class);
        return travelTimeDetailsDto;
    }

    public TravelTimeDetailsEntity convertToTravelTimeDetailsEntity(TravelTimeDetailsDto travelTimeDetailsDto) {
        TravelTimeDetailsEntity travelTimeDetailsEntity = modelMapper.map(travelTimeDetailsDto, TravelTimeDetailsEntity.class);
        return travelTimeDetailsEntity;
    }
    
}
