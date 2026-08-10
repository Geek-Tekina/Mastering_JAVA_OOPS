package com.designPattern.strategy;

public class Main {
    public static void main(String[] args) {
        Vehicle normalVehicle = new SimpleVehicle("Simple", new NormalDrive());
        Vehicle offRoadVehicle = new OffRoadVehicle("Offroad", new OffRoadDrive());

        System.out.println(normalVehicle.drive());
        System.out.println(offRoadVehicle.drive());

        Vehicle normalVehicle2 = new NormalVehicle1("OtherSimple");
        System.out.println(normalVehicle2.drive());
    }
}
