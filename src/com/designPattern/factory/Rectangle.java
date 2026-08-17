package com.designPattern.factory;

public class Rectangle implements Shape {

    public Rectangle() {
        System.out.println("Rectangle object created.");
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle.");
    }
}