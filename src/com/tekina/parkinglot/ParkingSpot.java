package com.tekina.parkinglot;

public class ParkingSpot {

    /*
        Generated Fields : spotId

        Mandatory Fields : spotNumber

        Optional Fields : parkedVehicle

        Mutable Fields :
        parkedVehicle

        Immutable Fields :
        spotId
        spotNumber

        Responsibilities :
        - Know whether it is occupied.
        - Assign a vehicle.
        - Remove a vehicle.
    */

    private static int nextSpotId = 1;

    private final int spotId;
    private final int spotNumber;

    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber) {

        this.spotId = nextSpotId++;
        this.spotNumber = spotNumber;
    }

    public int getSpotId() {
        return spotId;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public boolean parkVehicle(Vehicle vehicle) {

        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }

        if (!isAvailable()) {
            return false;
        }

        parkedVehicle = vehicle;
        return true;
    }

    public boolean removeVehicle() {

        if (isAvailable()) {
            return false;
        }

        parkedVehicle = null;
        return true;
    }

    @Override
    public String toString() {

        String status = isAvailable()
                ? "Available"
                : "Occupied by " + parkedVehicle.getVehicleNumber();

        return "ParkingSpot{" +
                "spotNumber=" + spotNumber +
                ", status='" + status + '\'' +
                '}';
    }
}