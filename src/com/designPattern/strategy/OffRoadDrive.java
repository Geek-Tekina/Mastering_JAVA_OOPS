package com.designPattern.strategy;

public class OffRoadDrive implements DriveStrategy{
    @Override
    public String drive() {
        return "This is special concrete implementation for OffRoad vehicles";
    }
}
