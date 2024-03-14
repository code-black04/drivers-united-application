package com.assignment.enums;

public enum JobOfferStatus {
    PENDING("Pending"), CONFIRMED("Confirmed"), CANCELLED("Cancelled"), IN_PROGRESS("In Progress");

    public final String jobOfferStatus;

    private JobOfferStatus(String jobOfferStatus) {
        this.jobOfferStatus = jobOfferStatus;
    }

    public static JobOfferStatus valueOfFeedbackStatus(String jobOfferStatus) {
        for (JobOfferStatus jobOfferStatusValue : values()) {
            if (jobOfferStatusValue.jobOfferStatus.equals(jobOfferStatus))
                return jobOfferStatusValue;
        }
        return null;
    }
}