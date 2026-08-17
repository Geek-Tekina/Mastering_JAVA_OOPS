package com.designPattern.abstractFactory;

public class StandardBike implements Bike {

    @Override
    public void ride() {
        System.out.println("Riding Standard Bike.");
    }
}