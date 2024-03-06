package com.assignment.dtos;

import com.assignment.enums.JobOfferStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobOfferDto {

    @JsonProperty(value = "jobOfferId")
    private Long jobOfferId;

    @JsonProperty(value = "driverId")
    private String driverId;

    @JsonProperty(value = "jobOfferStatus")
    private JobOfferStatus jobOfferStatus;

    @JsonProperty(value = "jobOfferDescription")
    private String jobOfferDescription;

    public Long getJobOfferId() {
        return jobOfferId;
    }

    public void setJobOfferId(Long jobOfferId) {
        this.jobOfferId = jobOfferId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
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
}
