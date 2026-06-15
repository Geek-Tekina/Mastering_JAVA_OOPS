package com.tekina.payment;

public class CreditCardPayment
        implements PaymentMethod {

    /*
        Mandatory Fields:
        cardNumber
        bankName
        cardHolderName

        Mutable Fields:
        cardHolderName

        Immutable Fields:
        cardNumber
        bankName

        Relationship:
        Realization

        Why?
        CreditCardPayment CAN process payments.
     */

    private final String cardNumber;
    private final String bankName;

    private String cardHolderName;

    public CreditCardPayment(
            String cardNumber,
            String bankName,
            String cardHolderName
    ) {

        if (cardNumber == null ||
                cardNumber.isBlank()) {

            throw new IllegalArgumentException(
                    "Card number cannot be blank."
            );
        }

        if (bankName == null ||
                bankName.isBlank()) {

            throw new IllegalArgumentException(
                    "Bank name cannot be blank."
            );
        }

        if (cardHolderName == null ||
                cardHolderName.isBlank()) {

            throw new IllegalArgumentException(
                    "Card holder name cannot be blank."
            );
        }

        this.cardNumber = cardNumber;
        this.bankName = bankName;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public boolean processPayment(
            double amount
    ) {

        System.out.println(
                "Processing Credit Card payment of ₹"
                        + amount
        );

        return true;
    }

    @Override
    public String getPaymentDetails() {

        return "Credit Card Payment"
                + " | Holder: "
                + cardHolderName
                + " | Bank: "
                + bankName;
    }
}