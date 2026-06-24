package com.tekina.shoppingCart;

public class CartItem {

    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {

        if (product == null) {
            throw new IllegalArgumentException(
                    "Product cannot be null"
            );
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero"
            );
        }

        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void increaseQuantity(int qty) {

        if (qty <= 0) {
            return;
        }

        quantity += qty;
    }

    public void decreaseQuantity(int qty) {

        if (qty <= 0) {
            return;
        }

        quantity -= qty;

        if (quantity < 0) {
            quantity = 0;
        }
    }

    public double getItemTotal() {
        return quantity * product.getPrice();
    }

    @Override
    public String toString() {
        return product +
                ", quantity=" + quantity +
                ", itemTotal=" + getItemTotal();
    }
}