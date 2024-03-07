package com.assignment.mapper;

import com.assignment.dtos.RouteAndTimeDetailsDto;
import com.assignment.entity.RouteAndTimeDetailsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteAndTimeDetailsDtoEntityMapper {

    @Autowired
    private ModelMapper modelMapper;

    private RouteAndTimeDetailsDto convertToRouteAndTimeDetailsDto(RouteAndTimeDetailsEntity routeAndTimeDetailsEntity) {
        RouteAndTimeDetailsDto routeAndTimeDetailsDto = modelMapper.map(routeAndTimeDetailsEntity, RouteAndTimeDetailsDto.class);
        return routeAndTimeDetailsDto;
    }

    private RouteAndTimeDetailsEntity convertToRouteAndTimeDetailsEntity(RouteAndTimeDetailsDto routeAndTimeDetailsDto) {
        RouteAndTimeDetailsEntity routeAndTimeDetailsEntity = modelMapper.map(routeAndTimeDetailsDto, RouteAndTimeDetailsEntity.class);
        return routeAndTimeDetailsEntity;
    }
    
}
