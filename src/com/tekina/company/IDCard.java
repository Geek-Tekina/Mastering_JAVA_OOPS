package com.tekina.company;

import java.time.LocalDate;

public class IDCard {

    /*
        Generated Fields:
        - cardNumber

        Mandatory Fields:
        - issueDate

        Optional Fields:
        - none

        Mutable Fields:
        - active

        Immutable Fields:
        - cardNumber
        - issueDate
    */

    private static int counter = 1000;

    private final int cardNumber;
    private final LocalDate issueDate;

    private boolean active;

    public IDCard() {

        this.cardNumber = counter++;
        this.issueDate = LocalDate.now();
        this.active = true;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void deactivate() {
        active = false;
    }

    @Override
    public String toString() {

        return "IDCard{" +
                "cardNumber=" + cardNumber +
                ", issueDate=" + issueDate +
                ", active=" + active +
                '}';
    }
}