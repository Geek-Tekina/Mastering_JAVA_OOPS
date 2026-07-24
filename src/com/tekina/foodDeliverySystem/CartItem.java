package com.tekina.foodDeliverySystem;

public class CartItem {

    // Generated : cartItemId

    // Mandatory : menuItem, quantity

    // Optional :

    // Mutable : quantity

    // Immutable : cartItemId

    private static int nextCartItemId = 1;

    private final int cartItemId;

    private final MenuItem menuItem;

    private int quantity;

    public CartItem(MenuItem menuItem, int quantity) {

        if (menuItem == null) {
            throw new IllegalArgumentException("Menu item cannot be null.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        this.cartItemId = nextCartItemId++;
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public void increaseQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        this.quantity += quantity;
    }

    public boolean decreaseQuantity() {

        if (this.quantity == 1) {
            return false;
        }

        this.quantity--;
        return true;
    }

    public boolean decreaseQuantity(int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        if (this.quantity - quantity < 1) {
            return false;
        }

        this.quantity -= quantity;
        return true;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", menuItem=" + menuItem +
                ", quantity=" + quantity +
                '}';
    }
}