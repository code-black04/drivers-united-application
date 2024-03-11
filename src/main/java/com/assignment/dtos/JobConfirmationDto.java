package com.assignment.dtos;

import com.assignment.enums.JobOfferStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobConfirmationDto {

    @JsonProperty(value = "jobOfferId")
    private Long jobOfferId;

    @JsonProperty(value = "jobOfferStatus")
    private JobOfferStatus jobOfferStatus;

    @JsonProperty(value = "driver")
    private DriverDto driver;
    @JsonProperty(value = "jobOffer")
    private JobOfferDto jobOffer;

    public JobConfirmationDto() {
    }

    public JobConfirmationDto(Long jobOfferId, JobOfferStatus jobOfferStatus, DriverDto driver, JobOfferDto jobOffer) {
        this.jobOfferId = jobOfferId;
        this.jobOfferStatus = jobOfferStatus;
        this.driver = driver;
        this.jobOffer = jobOffer;
    }

    public Long getJobOfferId() {
        return jobOfferId;
    }

    public void setJobOfferId(Long jobOfferId) {
        this.jobOfferId = jobOfferId;
    }

    public JobOfferStatus getJobOfferStatus() {
        return jobOfferStatus;
    }

    public void setJobOfferStatus(JobOfferStatus jobOfferStatus) {
        this.jobOfferStatus = jobOfferStatus;
    }

    public DriverDto getDriver() {
        return driver;
    }

    public void setDriver(DriverDto driver) {
        this.driver = driver;
    }

    public JobOfferDto getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOfferDto jobOffer) {
        this.jobOffer = jobOffer;
    }

    @Override
    public String toString() {
        return "JobConfirmationDto{" +
                "jobOfferId=" + jobOfferId +
                ", jobOfferStatus=" + jobOfferStatus +
                ", driver=" + driver +
                ", jobOffer=" + jobOffer +
                '}';
    }
}
