package com.designPattern.abstractFactory;

public class VehicleFactoryProvider {

    public static VehicleFactory getFactory(VehicleType vehicleType) {

        if (vehicleType == null) {
            throw new IllegalArgumentException(
                    "Vehicle type cannot be null."
            );
        }

        return switch (vehicleType) {

            case LUXURY ->
                    new LuxuryVehicleFactory();

            case STANDARD ->
                    new StandardVehicleFactory();
        };
    }
}