package com.tekina.foodDeliverySystem;

public class DeliveryPartner {

    // Generated : partnerId

    // Mandatory : name, phoneNumber, governmentId

    // Optional :

    // Mutable : name, phoneNumber

    // Immutable : partnerId, governmentId

    private static int nextPartnerId = 1;

    private final int partnerId;

    private String name;
    private String phoneNumber;

    private final String governmentId;
}