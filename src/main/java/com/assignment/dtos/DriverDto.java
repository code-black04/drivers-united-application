package com.assignment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties({"feedbacks", "paymentDetailsList", "jobOffers"})
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

    public DriverDto() {
    }

    public DriverDto(String driverId, String userName, String password, List<FeedbackDto> feedbacks, List<PaymentDetailsDto> paymentDetailsList, List<JobOfferDto> jobOffers) {
        this.driverId = driverId;
        this.userName = userName;
        this.password = password;
        this.feedbacks = feedbacks;
        this.paymentDetailsList = paymentDetailsList;
        this.jobOffers = jobOffers;
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

    @Override
    public String toString() {
        return "DriverDto{" +
                "driverId='" + driverId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", feedbacks=" + feedbacks +
                ", paymentDetailsList=" + paymentDetailsList +
                ", jobOffers=" + jobOffers +
                '}';
    }
}
