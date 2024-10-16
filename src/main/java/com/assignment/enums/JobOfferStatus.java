package com.assignment.enums;

public enum JobOfferStatus {

    IN_PROGRESS("In-Progress"),
    SUBMIT("Submit"),
    CONFIRMED("Confirmed"),
    CANCELLED("Cancelled");

    public final String feedbackStatus;

    private JobOfferStatus(String feedbackStatus) {
        this.feedbackStatus = feedbackStatus;
    }


    public static JobOfferStatus valueOfFeedbackStatus(String feedbackStatus) {
        for (JobOfferStatus jobOfferStatusValue : values()) {
            if (jobOfferStatusValue.feedbackStatus.equals(feedbackStatus))
                return jobOfferStatusValue;
        }
        return null;
    }

    @Override
    public String toString() {
        return "JobOfferStatus{" +
                "feedbackStatus='" + feedbackStatus + '\'' +
                '}';
    }
}


