package com.designPattern.decorator;

public abstract class BasePizza {
    public BasePizza(){
        System.out.println("Base Pizza Default Constructor called.");
    }
    public abstract int cost();
}
