package com.tekina.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingTicket {

    /*
        Generated Fields : ticketId

        Mandatory Fields :
        vehicle
        parkingSpot

        Optional Fields :
        exitTime

        Mutable Fields :
        exitTime
        amount
        paid

        Responsibilities :
        - Store parking details.
        - Calculate parking fee.
        - Mark payment status.
    */

    private static int nextTicketId = 1;

    private final int ticketId;

    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;

    private final LocalDateTime entryTime;

    private LocalDateTime exitTime;

    private double amount;

    private boolean paid;

    public ParkingTicket(Vehicle vehicle,
                         ParkingSpot parkingSpot) {

        if (vehicle == null || parkingSpot == null) {
            throw new IllegalArgumentException();
        }

        this.ticketId = nextTicketId++;

        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;

        this.entryTime = LocalDateTime.now();
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public double calculateFee(double hourlyRate) {

        exitTime = LocalDateTime.now();

        long hours = Duration.between(entryTime, exitTime).toHours();

        if (hours == 0) {
            hours = 1;
        }

        amount = hours * hourlyRate;

        return amount;
    }

    public void markPaid() {
        paid = true;
    }

    @Override
    public String toString() {

        return "Ticket{" +
                "ticketId=" + ticketId +
                ", vehicle=" + vehicle.getVehicleNumber() +
                ", spot=" + parkingSpot.getSpotNumber() +
                ", amount=" + amount +
                ", paid=" + paid +
                '}';
    }
}