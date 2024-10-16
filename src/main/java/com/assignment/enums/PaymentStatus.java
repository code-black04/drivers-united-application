package com.assignment.enums;

public enum PaymentStatus {
    INITIALISE("Initialise"),
    PROCESSING("Processing"),
    COMPLETED("Completed");

    public final String PaymentStatus;

    private PaymentStatus(String PaymentStatus) {
        this.PaymentStatus = PaymentStatus;
    }


    public static PaymentStatus valueOfPaymentStatus(String PaymentStatus) {
        for (PaymentStatus PaymentStatusValue : values()) {
            if (PaymentStatusValue.PaymentStatus.equals(PaymentStatus))
                return PaymentStatusValue;
        }
        return null;
    }

    @Override
    public String toString() {
        return "PaymentStatus{" +
                "PaymentStatus='" + PaymentStatus + '\'' +
                '}';
    }
}