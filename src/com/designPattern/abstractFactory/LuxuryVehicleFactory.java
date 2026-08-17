package com.designPattern.abstractFactory;

public class LuxuryVehicleFactory implements VehicleFactory {

    @Override
    public Car createCar() {
        return new LuxuryCar();
    }

    @Override
    public Bike createBike() {
        return new LuxuryBike();
    }
}