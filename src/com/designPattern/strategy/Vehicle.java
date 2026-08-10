package com.designPattern.strategy;

public class Vehicle {
    private final String vehicleName;
    private DriveStrategy driveStrategy;

    public Vehicle(String vehicleName, DriveStrategy driveStrategy){
        if(vehicleName == null || vehicleName.isEmpty() || driveStrategy == null){
            throw new IllegalArgumentException("Invalid Arguments");
        }
        this.vehicleName = vehicleName;
        this.driveStrategy = driveStrategy; // This is Constructor Injection
    }

    public String drive(){
        return this.driveStrategy.drive(); // Beautifully de-coupling the behaviour , The Vehicle doesn't know how driving happens.
    }
}
