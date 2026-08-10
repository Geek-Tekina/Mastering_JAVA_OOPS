package com.designPattern.strategy;

public class NormalVehicle1 extends Vehicle{
    // a little difference, here the class itself is binding the behavoiour , not taking from main class
    public NormalVehicle1(String vehicleName) {
        super(vehicleName, new NormalDrive());
    }
}
