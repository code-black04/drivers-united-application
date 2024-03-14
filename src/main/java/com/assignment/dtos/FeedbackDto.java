package com.assignment.dtos;

import com.assignment.enums.FeedbackStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FeedbackDto {

    @JsonProperty(value = "feedbackId")
    private Long feedbackId;

    @JsonProperty(value = "feedbackStatus")
    private FeedbackStatus feedbackStatus;

    @JsonProperty(value = "feedbackDescription")
    private String feedbackDescription;

    @JsonProperty(value = "driver")
    private DriverDto driver;

    public FeedbackDto() {
    }

    public FeedbackDto(Long feedbackId, FeedbackStatus feedbackStatus, String feedbackDescription, DriverDto driver) {
        this.feedbackId = feedbackId;
        this.feedbackStatus = feedbackStatus;
        this.feedbackDescription = feedbackDescription;
        this.driver = driver;
    }

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public FeedbackStatus getFeedbackStatus() {
        return feedbackStatus;
    }

    public void setFeedbackStatus(FeedbackStatus feedbackStatus) {
        this.feedbackStatus = feedbackStatus;
    }

    public String getFeedbackDescription() {
        return feedbackDescription;
    }

    public void setFeedbackDescription(String feedbackDescription) {
        this.feedbackDescription = feedbackDescription;
    }

    public DriverDto getDriver() {
        return driver;
    }

    public void setDriver(DriverDto driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "FeedbackDto{" +
                "feedbackId=" + feedbackId +
                ", feedbackStatus=" + feedbackStatus +
                ", feedbackDescription='" + feedbackDescription + '\'' +
                ", driver=" + driver +
                '}';
    }
}
