package com.tekina.shoppingCart;

public class PercentageDiscount implements DiscountStrategy {

    private final double percentage;

    public PercentageDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException(
                    "Percentage must be between 0 and 100"
            );
        }

        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double amount) {
        return amount - (amount * percentage / 100);
    }
}