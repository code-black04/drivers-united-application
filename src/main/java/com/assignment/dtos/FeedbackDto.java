package com.assignment.dtos;

import com.assignment.enums.FeedbackStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FeedbackDto {

    @JsonProperty(value = "feedbackId")
    private Long feedbackId;

    @JsonProperty(value = "driverId")
    private String driverId;

    @JsonProperty(value = "feedbackStatus")
    private FeedbackStatus feedbackStatus;

    @JsonProperty(value = "feedbackDescription")
    private String feedbackDescription;

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
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
}
