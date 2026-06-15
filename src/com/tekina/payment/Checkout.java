package com.tekina.payment;

public class Checkout {

    public boolean makePayment(
            PaymentMethod paymentMethod,
            double amount
    ) {

        if (amount <= 0) {
            System.out.println(
                    "Amount must be greater than zero."
            );
            return false;
        }

        boolean success =
                paymentMethod.processPayment(amount);

        if (success) {
            System.out.println(
                    paymentMethod.getPaymentDetails()
            );
        }

        return success;
    }
}