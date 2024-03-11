package com.assignment.entity;

import com.assignment.enums.JobOfferStatus;

import javax.persistence.*;

@Entity
@Table(name = "job_confirmation")
public class JobConfirmationEntity {

    @Id
    @Column(name = "job_confirmation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobConfirmationId;
    @Column(name = "job_offer_status")
    private JobOfferStatus jobOfferStatus;
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private DriverEntity driver;
    @OneToOne
    @JoinColumn(name = "job_offer_id")
    private JobOfferEntity jobOffer;

    public JobConfirmationEntity() {
    }

    public JobConfirmationEntity(Long jobConfirmationId, JobOfferStatus jobOfferStatus, DriverEntity driver, JobOfferEntity jobOffer) {
        this.jobConfirmationId = jobConfirmationId;
        this.jobOfferStatus = jobOfferStatus;
        this.driver = driver;
        this.jobOffer = jobOffer;
    }

    public Long getJobConfirmationId() {
        return jobConfirmationId;
    }

    public void setJobConfirmationId(Long jobConfirmationId) {
        this.jobConfirmationId = jobConfirmationId;
    }

    public DriverEntity getDriver() {
        return driver;
    }

    public void setDriver(DriverEntity driver) {
        this.driver = driver;
    }

    public JobOfferEntity getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOfferEntity jobOffer) {
        this.jobOffer = jobOffer;
    }


    public JobOfferStatus getJobOfferStatus() {
        return jobOfferStatus;
    }

    public void setJobOfferStatus(JobOfferStatus jobOfferStatus) {
        this.jobOfferStatus = jobOfferStatus;
    }

    @Override
    public String toString() {
        return "JobConfirmationEntity{" +
                "jobConfirmationId=" + jobConfirmationId +
                ", jobOfferStatus=" + jobOfferStatus +
                ", driver=" + driver +
                ", jobOffer=" + jobOffer +
                '}';
    }
}
