package com.assignment.entity;

import com.assignment.enums.JobOfferStatus;

import javax.persistence.*;

@Entity
@Table(name = "delivery_job_offer")
public class DeliveryJobOfferEntity {


    @Id
    @Column(name = "job_offer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobOfferId;

    @Column(name = "job_offer_status")
    private JobOfferStatus jobOfferStatus;

    @Column(name = "job_offer_description")
    private String jobOfferDescription;

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

    public String getJobOfferDescription() {
        return jobOfferDescription;
    }

    public void setJobOfferDescription(String jobOfferDescription) {
        this.jobOfferDescription = jobOfferDescription;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "JobOfferEntity{" +
                "jobOfferId=" + jobOfferId +
                ", jobOfferStatus=" + jobOfferStatus +
                ", jobOfferDescription='" + jobOfferDescription + '\'' +
                ", driverId='" + driverId + '\'' +
                '}';
    }
}


