package com.tekina.payment;

public class UpiPayment
        implements PaymentMethod {

    private final String upiId;

    public UpiPayment(String upiId) {

        if (upiId == null ||
                upiId.isBlank()) {

            throw new IllegalArgumentException(
                    "UPI ID cannot be blank."
            );
        }

        if (!upiId.contains("@")) {

            throw new IllegalArgumentException(
                    "Invalid UPI ID."
            );
        }

        this.upiId = upiId;
    }

    @Override
    public boolean processPayment(
            double amount
    ) {

        System.out.println(
                "Processing UPI payment of ₹"
                        + amount
        );

        return true;
    }

    @Override
    public String getPaymentDetails() {

        return "UPI Payment"
                + " | UPI ID: "
                + upiId;
    }
}