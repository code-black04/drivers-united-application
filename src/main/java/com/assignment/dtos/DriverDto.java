package com.assignment.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DriverDto {

    @JsonProperty(value = "driverId")
    private String driverId;

    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "password")
    private String password;

    @JsonProperty(value = "feedbacks")
    private List<FeedbackDto> feedbacks;

    @JsonProperty(value = "paymentDetailsList")
    private List<PaymentDetailsDto> paymentDetailsList;

    @JsonProperty(value = "jobOffers")
    private List<JobOfferDto> jobOffers;

    @JsonProperty(value = "jobConfirmations")
    private List<JobConfirmationDto> jobConfirmations;

    public DriverDto() {
    }

    public DriverDto(String driverId, String userName, String password, List<FeedbackDto> feedbacks, List<PaymentDetailsDto> paymentDetailsList, List<JobOfferDto> jobOffers, List<JobConfirmationDto> jobConfirmations) {
        this.driverId = driverId;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<FeedbackDto> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<FeedbackDto> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<PaymentDetailsDto> getPaymentDetailsList() {
        return paymentDetailsList;
    }

    public void setPaymentDetailsList(List<PaymentDetailsDto> paymentDetailsList) {
        this.paymentDetailsList = paymentDetailsList;
    }

    public List<JobOfferDto> getJobOffers() {
        return jobOffers;
    }

    public void setJobOffers(List<JobOfferDto> jobOffers) {
        this.jobOffers = jobOffers;
    }

    public List<JobConfirmationDto> getJobConfirmations() {
        return jobConfirmations;
    }

    public void setJobConfirmations(List<JobConfirmationDto> jobConfirmations) {
        this.jobConfirmations = jobConfirmations;
    }

    @Override
    public String toString() {
        return "DriverDto{" +
                "driverId='" + driverId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", feedbacks=" + feedbacks +
                ", paymentDetailsList=" + paymentDetailsList +
                ", jobOffers=" + jobOffers +
                ", jobConfirmations=" + jobConfirmations +
                '}';
    }
}
