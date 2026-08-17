package com.designPattern.abstractFactory;

import java.util.Scanner;
//User
// ↓
//LUXURY
// ↓
//VehicleFactoryProvider
// ↓
//LuxuryVehicleFactory
// ↓
//         ┌─────────────┐
//         ↓             ↓
//LuxuryCar        LuxuryBike
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Vehicle Family:");
        System.out.println("1. Luxury");
        System.out.println("2. Standard");

        int choice = scanner.nextInt();

        VehicleType vehicleType;

        switch (choice) {
            case 1:
                vehicleType = VehicleType.LUXURY;
                break;

            case 2:
                vehicleType = VehicleType.STANDARD;
                break;

            default:
                throw new IllegalArgumentException(
                        "Invalid vehicle family."
                );
        }

        // Select the appropriate family factory
        VehicleFactory factory =
                VehicleFactoryProvider.getFactory(vehicleType);

        // Now create products from that family
        Car car = factory.createCar();
        Bike bike = factory.createBike();

        car.drive();
        bike.ride();

        scanner.close();
    }
}