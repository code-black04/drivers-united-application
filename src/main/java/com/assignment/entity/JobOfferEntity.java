package com.assignment.entity;

import com.assignment.enums.JobOfferStatus;

import javax.persistence.*;

@Entity
@Table(name = "job_offer")
public class JobOfferEntity {

    @Id
    @Column(name = "job_offer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobOfferId;

    @Column(name = "driver_id")
    private String driverId;

    @Column(name = "job_offer_status")
    private JobOfferStatus jobOfferStatus;

    @Column(name = "job_offer_description")
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
