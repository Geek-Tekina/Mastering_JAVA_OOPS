package com.tekina.parkinglot;

public class Main {

    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(
                "Tekina Parking",
                5,
                50.0
        );

        Vehicle car1 = new Vehicle("KA01AB1234");
        Vehicle car2 = new Vehicle("KA02CD5678");
        Vehicle car3 = new Vehicle("DL10XY9876");

        System.out.println("========== Parking Vehicles ==========\n");

        ParkingTicket ticket1 = parkingLot.parkVehicle(car1);
        ParkingTicket ticket2 = parkingLot.parkVehicle(car2);
        ParkingTicket ticket3 = parkingLot.parkVehicle(car3);

        System.out.println(ticket1);
        System.out.println(ticket2);
        System.out.println(ticket3);

        System.out.println("\n========== Available Spots ==========\n");

        parkingLot.displayAvailableSpots();

        System.out.println("\n========== Active Tickets ==========\n");

        parkingLot.displayActiveTickets();

        System.out.println("\n========== Unparking Vehicle ==========\n");

        double amount = parkingLot.unparkVehicle(ticket2.getTicketId());

        System.out.println("Parking Fee : " + amount);

        System.out.println("\n========== Available Spots After Exit ==========\n");

        parkingLot.displayAvailableSpots();

        System.out.println("\n========== Active Tickets After Exit ==========\n");

        parkingLot.displayActiveTickets();

        System.out.println("\n========== Parking Lot ==========\n");

        System.out.println(parkingLot);
    }
}