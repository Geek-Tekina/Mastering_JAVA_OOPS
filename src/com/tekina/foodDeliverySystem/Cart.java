package com.tekina.foodDeliverySystem;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    // Generated : cartId

    // Mandatory :

    // Optional : cartItems (CartItem)

    // Mutable : cartItems

    // Immutable : cartId


    /* Responsibilities
        1. Add Items to cart (while adding, do upsert not insert)
        2. Modify the quantity of a particular item inside Items
        3. Delete cart item (also consider the case of internal delete, if quantity becomes 0)
     */

    private static int nextCartId = 1;

    private final int cartId;

    private final List<CartItem> cartItems;

    public Cart() {
        this.cartId = nextCartId++;
        this.cartItems = new ArrayList<>();
    }

    private CartItem getCartItem(MenuItem menuItem) {

        if (menuItem == null) {
            return null;
        }

        for (CartItem item : this.cartItems) {

            if (item.getMenuItem().getMenuItemId()
                    == menuItem.getMenuItemId()) {
                return item;
            }

        }

        return null;
    }

    public boolean addItem(MenuItem menuItem) {

        if (menuItem == null) {
            return false;
        }

        CartItem cartItem = getCartItem(menuItem);

        if (cartItem == null) {
            this.cartItems.add(new CartItem(menuItem, 1));
        } else {
            cartItem.increaseQuantity();
        }

        return true;
    }

    public boolean addItem(MenuItem menuItem, int quantity) {

        if (menuItem == null || quantity <= 0) {
            return false;
        }

        CartItem cartItem = getCartItem(menuItem);

        if (cartItem == null) {
            this.cartItems.add(new CartItem(menuItem, quantity));
        } else {
            cartItem.increaseQuantity(quantity);
        }

        return true;
    }

    public boolean increaseQuantity(MenuItem menuItem) {

        if (menuItem == null) {
            return false;
        }

        CartItem cartItem = getCartItem(menuItem);

        if (cartItem == null) {
            return false;
        }

        cartItem.increaseQuantity();
        return true;
    }

    public boolean increaseQuantity(MenuItem menuItem, int quantity) {

        if (menuItem == null || quantity <= 0) {
            return false;
        }

        CartItem cartItem = getCartItem(menuItem);

        if (cartItem == null) {
            return false;
        }

        cartItem.increaseQuantity(quantity);
        return true;
    }

    public boolean decreaseQuantity(MenuItem menuItem) {

        if (menuItem == null) {
            return false;
        }

        CartItem cartItem = getCartItem(menuItem);

        if (cartItem == null) {
            return false;
        }

        if (!cartItem.decreaseQuantity()) {
            removeItem(menuItem);
        }

        return true;
    }

    public boolean decreaseQuantity(MenuItem menuItem, int quantity) {

        if (menuItem == null || quantity <= 0) {
            return false;
        }

        CartItem cartItem = getCartItem(menuItem);

        if (cartItem == null) {
            return false;
        }

        if (!cartItem.decreaseQuantity(quantity)) {
            removeItem(menuItem);
        }

        return true;
    }

    public boolean removeItem(MenuItem menuItem) {

        if (menuItem == null) {
            return false;
        }

        CartItem cartItem = getCartItem(menuItem);

        if (cartItem == null) {
            return false;
        }

        return this.cartItems.remove(cartItem);
    }

    public double calculateTotal() {

        double total = 0;

        for (CartItem item : this.cartItems) {
            total += item.getQuantity() * item.getMenuItem().getPrice();
        }

        return total;
    }

    public void clear() {
        this.cartItems.clear();
    }

    public List<CartItem> getCartItems() {
        return new ArrayList<>(this.cartItems);
    }

    public int getCartId() {
        return cartId;
    }

    @Override
    public String toString() {

        return "Cart{" +
                "cartId=" + cartId +
                ", totalItems=" + cartItems.size() +
                ", totalPrice=" + calculateTotal() +
                ", cartItems=" + cartItems +
                '}';
    }
}