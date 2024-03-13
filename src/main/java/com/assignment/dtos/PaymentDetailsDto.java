package com.assignment.dtos;

import com.assignment.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentDetailsDto {

    @JsonProperty(value = "paymentId")
    private String paymentId;

    @JsonProperty(value = "paymentAmount")
    private Float paymentAmount;

    @JsonProperty(value = "paymentStatus")
    private PaymentStatus paymentStatus;

    @JsonProperty(value = "jobOffer")
    private JobOfferDto jobOffer;

    @JsonProperty(value = "driver")
    private DriverDto driver;

    public PaymentDetailsDto() {
    }

    public PaymentDetailsDto(String paymentId, Float paymentAmount, PaymentStatus paymentStatus, JobOfferDto jobOffer, DriverDto driver) {
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
        this.jobOffer = jobOffer;
        this.driver = driver;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public JobOfferDto getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOfferDto jobOffer) {
        this.jobOffer = jobOffer;
    }

    public DriverDto getDriver() {
        return driver;
    }

    public void setDriver(DriverDto driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "PaymentDetailsDto{" +
                "paymentId='" + paymentId + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", paymentStatus=" + paymentStatus +
                ", jobOffer=" + jobOffer +
                ", driver=" + driver +
                '}';
    }
}
