package com.designPattern.strategy;

public class SimpleVehicle extends Vehicle{

    public SimpleVehicle(String vehicleName, DriveStrategy driveStrategy) {
        super(vehicleName, driveStrategy);
    }
}
