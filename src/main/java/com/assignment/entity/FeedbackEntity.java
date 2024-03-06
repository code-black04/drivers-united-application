package com.assignment.entity;

import com.assignment.enums.FeedbackStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "feedback_report")
public class FeedbackEntity {

    @Id
    @Column(name = "feedback_id")
    private Long feedbackId;

    @Column(name = "driver_id")
    private String driverId;

    @Column(name = "feedback_status")
    private FeedbackStatus feedbackStatus;

    @Column(name = "feedback_description")
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
