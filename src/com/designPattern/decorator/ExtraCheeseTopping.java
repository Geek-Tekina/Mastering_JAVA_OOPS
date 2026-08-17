package com.designPattern.decorator;

public class ExtraCheeseTopping extends PizzaTopping{

    private final BasePizza basePizza;

    ExtraCheeseTopping(BasePizza basePizza){
        this.basePizza = basePizza;
        System.out.println("Extra Cheese Topping Default Constructor called.");
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 60;
    }
}
