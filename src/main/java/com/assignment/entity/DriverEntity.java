package com.assignment.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "driver_details")
public class DriverEntity {

    @Column(name = "driver_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String driverId;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.REMOVE)
    private List<FeedbackEntity> feedbacks;

    @OneToMany
    @JoinColumn(name="driver_id")
    private List<PaymentDetailsEntity> paymentDetailsList;

    @OneToMany
    @JoinColumn(name="driver_id")
    private List<JobOfferEntity> jobOffers;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.REMOVE)
    private List<JobConfirmationEntity> jobConfirmations;

    public DriverEntity() {
    }

    public DriverEntity(String driverId, String password, List<FeedbackEntity> feedbacks, List<PaymentDetailsEntity> paymentDetailsList, List<JobOfferEntity> jobOffers, List<JobConfirmationEntity> jobConfirmations) {
        this.driverId = driverId;
        this.password = password;
        this.feedbacks = feedbacks;
        this.paymentDetailsList = paymentDetailsList;
        this.jobOffers = jobOffers;
        this.jobConfirmations = jobConfirmations;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<FeedbackEntity> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<FeedbackEntity> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<PaymentDetailsEntity> getPaymentDetailsList() {
        return paymentDetailsList;
    }

    public void setPaymentDetailsList(List<PaymentDetailsEntity> paymentDetailsList) {
        this.paymentDetailsList = paymentDetailsList;
    }

    public List<JobOfferEntity> getJobOffers() {
        return jobOffers;
    }

    public void setJobOffers(List<JobOfferEntity> jobOffers) {
        this.jobOffers = jobOffers;
    }

    public List<JobConfirmationEntity> getJobConfirmations() {
        return jobConfirmations;
    }

    public void setJobConfirmations(List<JobConfirmationEntity> jobConfirmations) {
        this.jobConfirmations = jobConfirmations;
    }

    @Override
    public String toString() {
        return "DriverEntity{" +
                "driverId='" + driverId + '\'' +
                ", password='" + password + '\'' +
                ", feedbacks=" + feedbacks +
                ", paymentDetailsList=" + paymentDetailsList +
                ", jobOffers=" + jobOffers +
                ", jobConfirmations=" + jobConfirmations +
                '}';
    }
}
