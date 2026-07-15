package com.tekina.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    /*
        Generated Fields : registrationNumber

        Mandatory Fields :
        name
        totalSpots
        hourlyRate

        Optional Fields :
        activeTickets

        Mutable Fields :
        name
        hourlyRate

        Immutable Fields :
        registrationNumber
        parkingSpots
        activeTickets
    */

    private static int nextRegistrationNumber = 1;

    private final int registrationNumber;
    private String name;

    private final List<ParkingSpot> parkingSpots;
    private final List<ParkingTicket> activeTickets;

    private double hourlyRate;

    public ParkingLot(String name, int totalSpots, double hourlyRate) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Parking lot name cannot be null or blank.");
        }

        if (totalSpots <= 0) {
            throw new IllegalArgumentException("Parking lot must have at least one parking spot.");
        }

        if (hourlyRate <= 0) {
            throw new IllegalArgumentException("Hourly rate must be positive.");
        }

        this.registrationNumber = nextRegistrationNumber++;
        this.name = name;
        this.hourlyRate = hourlyRate;

        this.parkingSpots = new ArrayList<>();
        this.activeTickets = new ArrayList<>();

        for (int i = 1; i <= totalSpots; i++) {
            parkingSpots.add(new ParkingSpot(i));
        }
    }

    // ==========================
    // Private Helper Methods
    // ==========================

    private ParkingSpot findAvailableSpot() {

        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable()) {
                return spot;
            }
        }

        return null;
    }

    private ParkingTicket findTicket(int ticketId) {

        for (ParkingTicket ticket : activeTickets) {
            if (ticket.getTicketId() == ticketId) {
                return ticket;
            }
        }

        return null;
    }

    private boolean removeActiveTicket(ParkingTicket ticket) {
        return activeTickets.remove(ticket);
    }

    // ==========================
    // Business Methods
    // ==========================

    public ParkingTicket parkVehicle(Vehicle vehicle) {

        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }

        ParkingSpot availableSpot = findAvailableSpot();

        if (availableSpot == null) {
            System.out.println("Parking Lot is Full.");
            return null;
        }

        boolean parked = availableSpot.parkVehicle(vehicle);

        if (!parked) {
            return null;
        }

        ParkingTicket ticket =
                new ParkingTicket(vehicle, availableSpot);

        activeTickets.add(ticket);

        return ticket;
    }

    public double unparkVehicle(int ticketId) {

        ParkingTicket ticket = findTicket(ticketId);

        if (ticket == null) {
            System.out.println("Ticket not found.");
            return 0.0;
        }

        double amount = ticket.calculateFee(hourlyRate);

        // Mimic payment
        ticket.markPaid();

        ticket.getParkingSpot().removeVehicle();

        removeActiveTicket(ticket);

        return amount;
    }

    public void displayAvailableSpots() {

        System.out.println("\nAvailable Parking Spots");

        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable()) {
                System.out.println(spot);
            }
        }
    }

    public void displayActiveTickets() {

        System.out.println("\nActive Tickets");

        for (ParkingTicket ticket : activeTickets) {
            System.out.println(ticket);
        }
    }

    // ==========================
    // Getters
    // ==========================

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public String getName() {
        return name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "registrationNumber=" + registrationNumber +
                ", name='" + name + '\'' +
                ", totalSpots=" + parkingSpots.size() +
                ", activeTickets=" + activeTickets.size() +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}