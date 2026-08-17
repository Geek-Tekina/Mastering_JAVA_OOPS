package com.designPattern.factory;

public class Main {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle =
                shapeFactory.createShape(ShapeType.CIRCLE);

        Shape rectangle =
                shapeFactory.createShape(ShapeType.RECTANGLE);

        circle.draw();
        rectangle.draw();
    }
}