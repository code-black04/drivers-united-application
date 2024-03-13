package com.assignment.enums;

public enum FeedbackStatus {

    PROCESSING("Processing"),
    RECEIVED("Received"),
    BLOCKED("Blocked"),
    SEND("Send"),
    ACCEPTED("Accepted");

    public final String feedbackStatus;

    private FeedbackStatus(String feedbackStatus) {
        this.feedbackStatus = feedbackStatus;
    }


    public static FeedbackStatus valueOfFeedbackStatus(String feedbackStatus) {
        for (FeedbackStatus feedbackStatusValue : values()) {
            if (feedbackStatusValue.feedbackStatus.equals(feedbackStatus))
                return feedbackStatusValue;
        }
        return null;
    }

    @Override
    public String toString() {
        return "FeedbackStatus{" +
                "feedbackStatus='" + feedbackStatus + '\'' +
                '}';
    }
}
