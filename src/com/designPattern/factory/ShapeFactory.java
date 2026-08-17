package com.designPattern.factory;

public class ShapeFactory {

    public Shape createShape(ShapeType shapeType) {

        if (shapeType == null) {
            throw new IllegalArgumentException(
                    "Shape type cannot be null."
            );
        }

        return switch (shapeType) {
            case CIRCLE -> new Circle();
            case RECTANGLE -> new Rectangle();
        };
    }
}