package com.assignment.mapper;

import com.assignment.dtos.PaymentDetailsDto;
import com.assignment.entity.PaymentDetailsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class  PaymentDetailsDtoEntityMapper {

    @Autowired
    private ModelMapper modelMapper;

    private PaymentDetailsDto convertToPaymentDetailsDto(PaymentDetailsEntity paymentDetailsEntity) {
        PaymentDetailsDto paymentDetailsDto = modelMapper.map(paymentDetailsEntity, PaymentDetailsDto.class);
        return paymentDetailsDto;
    }
    
    private PaymentDetailsEntity convertToPaymentDetailsEntity(PaymentDetailsDto paymentDetailsDto) {
        PaymentDetailsEntity paymentDetailsEntity = modelMapper.map(paymentDetailsDto, PaymentDetailsEntity.class);
        return paymentDetailsEntity;
    }

}
