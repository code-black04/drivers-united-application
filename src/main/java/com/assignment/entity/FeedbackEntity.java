package com.assignment.entity;

import com.assignment.enums.FeedbackStatus;

import javax.persistence.*;

@Entity
@Table(name = "feedback_report")
public class FeedbackEntity {

    @Id
    @Column(name = "feedback_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedbackId;

    @Column(name = "feedback_status")
    private FeedbackStatus feedbackStatus;

    @Column(name = "feedback_description")
    private String feedbackDescription;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private DriverEntity driver;

    public FeedbackEntity() {
    }

    public FeedbackEntity(Long feedbackId, FeedbackStatus feedbackStatus, String feedbackDescription, DriverEntity driver) {
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

    public DriverEntity getDriver() {
        return driver;
    }

    public void setDriver(DriverEntity driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "FeedbackEntity{" +
                "feedbackId=" + feedbackId +
                ", feedbackStatus=" + feedbackStatus +
                ", feedbackDescription='" + feedbackDescription + '\'' +
                ", driver=" + driver +
                '}';
    }
}
