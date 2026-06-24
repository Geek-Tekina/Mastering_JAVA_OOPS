package com.tekina.shoppingCart;

public class Customer {

    private static int idCounter = 1;

    private final int customerId;
    private String name;
    private final ShoppingCart cart;

    public Customer(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Customer name cannot be blank"
            );
        }

        this.customerId = idCounter++;
        this.name = name;
        this.cart = new ShoppingCart();
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void viewCart() {
        cart.displayCart();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                '}';
    }
}