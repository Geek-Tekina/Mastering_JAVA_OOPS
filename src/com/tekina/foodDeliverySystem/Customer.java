package com.tekina.foodDeliverySystem;

import java.util.List;

public class Customer {

    // Generated : customerId, customerCart (Cart)

    // Mandatory : customerName, email, phoneNumber

    // Optional : gender, address, orders (Order)

    // Mutable : customerName, email, phoneNumber, gender, address

    // Immutable : customerId, customerCart

    private static int nextCustomerId = 1;

    private final int customerId;

    private final Cart customerCart;

    private String customerName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String address;

    private List<Order> orders;
}