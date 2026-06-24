package com.tekina.shoppingCart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {

    private static int idCounter = 1;

    private final int cartId;
    private final List<CartItem> items;

    public ShoppingCart() {
        this.cartId = idCounter++;
        this.items = new ArrayList<>();
    }

    public boolean addProduct(Product product, int quantity) {

        for (CartItem item : items) {

            if (item.getProduct().getProductId()
                    == product.getProductId()) {

                item.increaseQuantity(quantity);
                return true;
            }
        }

        return items.add(
                new CartItem(product, quantity)
        );
    }

    public boolean removeProduct(int productId) {

        Iterator<CartItem> iterator =
                items.iterator();

        while (iterator.hasNext()) {

            CartItem item = iterator.next();

            if (item.getProduct().getProductId()
                    == productId) {

                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public double getCartTotal() {

        double total = 0;

        for (CartItem item : items) {
            total += item.getItemTotal();
        }

        return total;
    }

    public double applyDiscount(
            DiscountStrategy strategy
    ) {
        return strategy.applyDiscount(
                getCartTotal()
        );
    }

    public void displayCart() {

        System.out.println("\n----- CART -----");

        for (CartItem item : items) {
            System.out.println(item);
        }

        System.out.println(
                "Total = " + getCartTotal()
        );
    }
}