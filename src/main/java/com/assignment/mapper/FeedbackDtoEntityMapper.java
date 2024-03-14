package com.assignment.mapper;

import com.assignment.dtos.FeedbackDto;
import com.assignment.entity.FeedbackEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeedbackDtoEntityMapper {

    @Autowired
    private ModelMapper modelMapper;

    public FeedbackDto convertToFeedbackDto(FeedbackEntity feedbackEntity) {
        FeedbackDto feedbackDto = modelMapper.map(feedbackEntity, FeedbackDto.class);
        return feedbackDto;
    }

    public FeedbackEntity convertToFeedbackEntity(FeedbackDto feedbackDto) {
        FeedbackEntity feedbackEntity = modelMapper.map(feedbackDto, FeedbackEntity.class);
        return feedbackEntity;
    }
}
