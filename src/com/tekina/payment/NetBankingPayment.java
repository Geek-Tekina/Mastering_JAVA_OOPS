package com.tekina.payment;

public class NetBankingPayment
        implements PaymentMethod {

    private final String accountNumber;
    private final String bankName;

    public NetBankingPayment(
            String accountNumber,
            String bankName
    ) {

        if (accountNumber == null ||
                accountNumber.isBlank()) {

            throw new IllegalArgumentException(
                    "Account number cannot be blank."
            );
        }

        if (bankName == null ||
                bankName.isBlank()) {

            throw new IllegalArgumentException(
                    "Bank name cannot be blank."
            );
        }

        this.accountNumber = accountNumber;
        this.bankName = bankName;
    }

    @Override
    public boolean processPayment(
            double amount
    ) {

        System.out.println(
                "Processing Net Banking payment of ₹"
                        + amount
        );

        return true;
    }

    @Override
    public String getPaymentDetails() {

        return "Net Banking Payment"
                + " | Account: "
                + accountNumber
                + " | Bank: "
                + bankName;
    }
}