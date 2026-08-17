package com.designPattern.decorator;

public class MushroomTopping extends PizzaTopping{

    private final BasePizza basePizza;

    public MushroomTopping(BasePizza basePizza){
        this.basePizza = basePizza;
        System.out.println("Mushroom Topping Default Constructor called.");
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 120;
    }
}
