package com.tekina.shoppingCart;

public class FlatDiscount implements DiscountStrategy {

    private final double discountAmount;

    public FlatDiscount(double discountAmount) {

        if (discountAmount < 0) {
            throw new IllegalArgumentException(
                    "Discount amount cannot be negative"
            );
        }

        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double amount) {
        return Math.max(0, amount - discountAmount);
    }
}