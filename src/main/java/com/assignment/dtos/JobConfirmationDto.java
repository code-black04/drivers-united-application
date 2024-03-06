package com.assignment.dtos;

import com.assignment.enums.JobOfferStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobConfirmationDto {

    @JsonProperty(value = "jobOfferId")
    private Long jobOfferId;

    @JsonProperty(value = "jobOfferStatus")
    private JobOfferStatus jobOfferStatus;

    @JsonProperty(value = "driverId")
    private String driverId;

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

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
}
