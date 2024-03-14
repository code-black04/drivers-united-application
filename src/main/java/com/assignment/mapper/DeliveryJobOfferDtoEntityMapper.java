package com.assignment.mapper;

import com.assignment.dtos.DeliveryJobOfferDTO;
import com.assignment.dtos.DriverDto;
import com.assignment.entity.DeliveryJobOfferEntity;
import com.assignment.entity.DriverEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryJobOfferDtoEntityMapper {

    @Autowired
    private ModelMapper modelMapper;

    public DeliveryJobOfferDTO convertToDeliveryJobOfferDto(DeliveryJobOfferEntity driverEntity) {
        DeliveryJobOfferDTO driverDto = modelMapper.map(driverEntity, DeliveryJobOfferDTO.class);
        return driverDto;
    }

    public DeliveryJobOfferEntity convertToDriverEntity(DeliveryJobOfferDTO driverDto) {
        DeliveryJobOfferEntity driverEntity = modelMapper.map(driverDto, DeliveryJobOfferEntity.class);
        return driverEntity;
    }

}
