package com.designPattern.decorator;

public class Margherita extends BasePizza{

    public Margherita(){
        System.out.println("Margherita Base Pizza Default Constructor called.");
    }
    @Override
    public int cost(){
        return 250;
    }
}
