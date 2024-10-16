package com.assignment.dtos;

import com.assignment.enums.JobOfferStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobOfferDto {

    @JsonProperty(value = "jobOfferId")
    private Long jobOfferId;

    @JsonProperty(value = "jobOfferStatus")
    private JobOfferStatus jobOfferStatus;

    @JsonProperty(value = "jobOfferDescription")
    private String jobOfferDescription;

    @JsonProperty(value = "driver")
    private DriverDto driver;

    @JsonProperty(value = "routeAndTimeDetails")
    private RouteAndTimeDetailsDto routeAndTimeDetails;

    @JsonProperty(value = "paymentDetails")
    private PaymentDetailsDto paymentDetails;

    public JobOfferDto() {
    }

    public JobOfferDto(Long jobOfferId, JobOfferStatus jobOfferStatus, String jobOfferDescription, DriverDto driver, RouteAndTimeDetailsDto routeAndTimeDetails, PaymentDetailsDto paymentDetails) {
        this.jobOfferId = jobOfferId;
        this.jobOfferStatus = jobOfferStatus;
        this.jobOfferDescription = jobOfferDescription;
        this.driver = driver;
        this.routeAndTimeDetails = routeAndTimeDetails;
        this.paymentDetails = paymentDetails;
    }

    public Long getJobOfferId() {
        return jobOfferId;
    }

    public void setJobOfferId(Long jobOfferId) {
        this.jobOfferId = jobOfferId;
    }

    public DriverDto getDriver() {
        return driver;
    }

    public void setDriver(DriverDto driver) {
        this.driver = driver;
    }

    public RouteAndTimeDetailsDto getRouteAndTimeDetails() {
        return routeAndTimeDetails;
    }

    public void setRouteAndTimeDetails(RouteAndTimeDetailsDto routeAndTimeDetails) {
        this.routeAndTimeDetails = routeAndTimeDetails;
    }

    public PaymentDetailsDto getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetailsDto paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public JobOfferStatus getJobOfferStatus() {
        return jobOfferStatus;
    }

    public void setJobOfferStatus(JobOfferStatus jobOfferStatus) {
        this.jobOfferStatus = jobOfferStatus;
    }

    public String getJobOfferDescription() {
        return jobOfferDescription;
    }

    public void setJobOfferDescription(String jobOfferDescription) {
        this.jobOfferDescription = jobOfferDescription;
    }

    @Override
    public String toString() {
        return "JobOfferDto{" +
                "jobOfferId=" + jobOfferId +
                ", jobOfferStatus=" + jobOfferStatus +
                ", jobOfferDescription='" + jobOfferDescription + '\'' +
                ", driver=" + driver +
                ", routeAndTimeDetails=" + routeAndTimeDetails +
                ", paymentDetails=" + paymentDetails +
                '}';
    }
}
