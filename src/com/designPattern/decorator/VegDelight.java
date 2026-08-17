package com.designPattern.decorator;

public class VegDelight extends BasePizza{

    public VegDelight(){
        System.out.println("VegDelight Base Pizza Default Constructor called.");
    }
    @Override
    public int cost() {
        return 450;
    }
}
