package com.tekina.payment;

public class Main {

    public static void main(String[] args) {

        PaymentMethod payment1 =
                new CreditCardPayment(
                        "4111222233334444",
                        "HDFC",
                        "Tekina"
                );

        PaymentMethod payment2 =
                new UpiPayment(
                        "tekina@ibl"
                );

        PaymentMethod payment3 =
                new NetBankingPayment(
                        "9876543210",
                        "Axis Bank"
                );

        Checkout checkout =
                new Checkout();

        checkout.makePayment(
                payment1,
                2500
        );

        System.out.println(
                "----------------"
        );

        checkout.makePayment(
                payment2,
                999
        );

        System.out.println(
                "----------------"
        );

        checkout.makePayment(
                payment3,
                10000
        );

        System.out.println(
                "----------------"
        );

        checkout.makePayment(
                payment1,
                0
        );
    }
}