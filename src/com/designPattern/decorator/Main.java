package com.designPattern.decorator;

public class Main {
    public static void main(String[] args){
        BasePizza myPizza = new ExtraCheeseTopping(new Margherita());
        System.out.println(myPizza.cost());
    }
}
