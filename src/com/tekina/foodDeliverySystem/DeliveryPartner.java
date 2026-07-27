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

    public DeliveryPartner(String name, String phoneNumber, String governmentId) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }

        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty.");
        }

        if (governmentId == null || governmentId.isBlank()) {
            throw new IllegalArgumentException("Government ID cannot be null or empty.");
        }

        this.partnerId = nextPartnerId++;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.governmentId = governmentId;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGovernmentId() {
        return governmentId;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty.");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "DeliveryPartner{" +
                "partnerId=" + partnerId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", governmentId='" + governmentId + '\'' +
                '}';
    }
}