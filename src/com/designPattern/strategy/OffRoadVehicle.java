package com.designPattern.strategy;

public class OffRoadVehicle extends Vehicle{
    public OffRoadVehicle(String vehicleName, DriveStrategy driveStrategy) {
        super(vehicleName, driveStrategy);
    }
}
