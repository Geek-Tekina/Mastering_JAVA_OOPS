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

    private List<CartItem> cartItems;

    public Cart()

    private CartItem getCartItem(MenuItem menuItem)

    public boolean addItem(MenuItem menuItem)

    public boolean addItem(MenuItem menuItem, int quantity)

    public boolean increaseQuantity(MenuItem menuItem)

    public boolean increaseQuantity(MenuItem menuItem, int quantity)

    public boolean decreaseQuantity(MenuItem menuItem)

    public boolean decreaseQuantity(MenuItem menuItem, int quantity)

    public boolean removeItem(MenuItem menuItem)

    public double calculateTotal()

    public void clear()

    public List<CartItem> getCartItems()

    public int getCartId()

    @Override
    public String toString()
}