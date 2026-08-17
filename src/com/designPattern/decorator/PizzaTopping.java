package com.designPattern.decorator;

public abstract class PizzaTopping extends BasePizza {
    // the beauty here is, this is having both the relations with Base Pizza.
    // 1. Has a, 2. Is a
    public PizzaTopping(){
        System.out.println("Pizza Topping Default Constructor called.");
    }
}
