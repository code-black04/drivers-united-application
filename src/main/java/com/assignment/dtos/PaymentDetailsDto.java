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

    @JsonProperty(value = "jobOfferId")
    private String jobOfferId;

    @JsonProperty(value = "driverId")
    private String driverId;

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

    public String getJobOfferId() {
        return jobOfferId;
    }

    public void setJobOfferId(String jobOfferId) {
        this.jobOfferId = jobOfferId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
}
