package com.designPattern.strategy;

public class NormalDrive implements DriveStrategy{
    @Override
    public String drive(){
        return "This is the concrete implementation of Normal Drive Class";
    }
}
