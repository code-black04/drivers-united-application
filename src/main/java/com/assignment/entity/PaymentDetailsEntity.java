package com.assignment.entity;

import com.assignment.enums.PaymentStatus;

import javax.persistence.*;

@Entity
@Table(name = "payment_details")
public class PaymentDetailsEntity {

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;

    @Column(name = "payment_amount")
    private Float paymentAmount;

    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

    @OneToOne
    @JoinColumn(name = "job_offer_id")
    private JobOfferEntity jobOffer;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private DriverEntity driver;


    public PaymentDetailsEntity(Long paymentId, Float paymentAmount, PaymentStatus paymentStatus, JobOfferEntity jobOffer, DriverEntity driver) {
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
        this.jobOffer = jobOffer;
        this.driver = driver;
    }

    public PaymentDetailsEntity() {
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
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

    public JobOfferEntity getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOfferEntity jobOffer) {
        this.jobOffer = jobOffer;
    }

    public DriverEntity getDriver() {
        return driver;
    }

    public void setDriver(DriverEntity driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "PaymentDetailsEntity{" +
                "paymentId=" + paymentId +
                ", paymentAmount=" + paymentAmount +
                ", paymentStatus=" + paymentStatus +
                ", jobOffer=" + jobOffer +
                ", driver=" + driver +
                '}';
    }
}
