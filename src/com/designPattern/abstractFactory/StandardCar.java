package com.designPattern.abstractFactory;

public class StandardCar implements Car {

    @Override
    public void drive() {
        System.out.println("Driving Standard Car.");
    }
}