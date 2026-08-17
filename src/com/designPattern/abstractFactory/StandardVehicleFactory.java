package com.designPattern.abstractFactory;

public class StandardVehicleFactory implements VehicleFactory {

    @Override
    public Car createCar() {
        return new StandardCar();
    }

    @Override
    public Bike createBike() {
        return new StandardBike();
    }
}