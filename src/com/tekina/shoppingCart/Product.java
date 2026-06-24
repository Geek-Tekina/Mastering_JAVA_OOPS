package com.tekina.shoppingCart;

public class Product {

    private static int idCounter = 1;

    private final int productId;
    private String name;
    private double price;

    public Product(String name, double price) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Product name cannot be blank"
            );
        }

        if (price < 0) {
            throw new IllegalArgumentException(
                    "Price cannot be negative"
            );
        }

        this.productId = idCounter++;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public void updatePrice(double newPrice) {

        if (newPrice < 0) {
            throw new IllegalArgumentException(
                    "Price cannot be negative"
            );
        }

        this.price = newPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}