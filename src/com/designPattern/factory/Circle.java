package com.designPattern.factory;

public class Circle implements Shape {

    public Circle() {
        System.out.println("Circle object created.");
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle.");
    }
}