package com.tekina.parkinglot;

public class Vehicle {

    /*
        Generated Fields : vehicleId

        Mandatory Fields : vehicleNumber

        Optional Fields :

        Mutable Fields :

        Immutable Fields :
        vehicleId
        vehicleNumber

        Responsibilities :
        - Store vehicle information.
    */

    private static int nextVehicleId = 1;

    private final int vehicleId;
    private final String vehicleNumber;

    public Vehicle(String vehicleNumber) {

        if (vehicleNumber == null || vehicleNumber.isBlank()) {
            throw new IllegalArgumentException("Vehicle number cannot be null or blank.");
        }

        this.vehicleId = nextVehicleId++;
        this.vehicleNumber = vehicleNumber;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                '}';
    }
}