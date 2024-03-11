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

    @Column(name = "job_offer_status")
    private JobOfferStatus jobOfferStatus;

    @Column(name = "job_offer_description")
    private String jobOfferDescription;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private DriverEntity driver;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "route_and_time_details_id")
    private RouteAndTimeDetailsEntity routeAndTimeDetails;

    @OneToOne(mappedBy = "jobOffer",cascade = CascadeType.ALL)
    private PaymentDetailsEntity paymentDetails;

    @OneToOne(mappedBy = "jobOffer")
    private JobConfirmationEntity jobConfirmation;


    public JobOfferEntity() {
    }

    public JobOfferEntity(Long jobOfferId, JobOfferStatus jobOfferStatus, String jobOfferDescription, DriverEntity driver, RouteAndTimeDetailsEntity routeAndTimeDetails, PaymentDetailsEntity paymentDetails, JobConfirmationEntity jobConfirmation) {
        this.jobOfferId = jobOfferId;
        this.jobOfferStatus = jobOfferStatus;
        this.jobOfferDescription = jobOfferDescription;
        this.driver = driver;
        this.routeAndTimeDetails = routeAndTimeDetails;
        this.paymentDetails = paymentDetails;
        this.jobConfirmation = jobConfirmation;
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

    public String getJobOfferDescription() {
        return jobOfferDescription;
    }

    public void setJobOfferDescription(String jobOfferDescription) {
        this.jobOfferDescription = jobOfferDescription;
    }

    public DriverEntity getDriver() {
        return driver;
    }

    public void setDriver(DriverEntity driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "JobOfferEntity{" +
                "jobOfferId=" + jobOfferId +
                ", jobOfferStatus=" + jobOfferStatus +
                ", jobOfferDescription='" + jobOfferDescription + '\'' +
                ", driver=" + driver +
                ", routeAndTimeDetails=" + routeAndTimeDetails +
                ", paymentDetails=" + paymentDetails +
                ", jobConfirmation=" + jobConfirmation +
                '}';
    }
}
