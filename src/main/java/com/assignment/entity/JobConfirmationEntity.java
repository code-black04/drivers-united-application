package com.assignment.entity;

import com.assignment.enums.JobOfferStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_confirmation")
public class JobConfirmationEntity {

    @Id
    @Column(name = "job_offer_id")
    private Long jobOfferId;

    @Column(name = "job_offer_status")
    private JobOfferStatus jobOfferStatus;

    @Column(name = "driver_id")
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
