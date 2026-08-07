package com.tekina.foodDeliverySystem;

public class OrderItem {

    // Generated : orderItemId

    // Mandatory :
    // Optional : (we will accept menuItem to create -> name, price, and other related info)
    // orderedItemName, orderedItemPrice, orderedItemQuantity

    // Mutable :

    // Immutable : orderItemId

    private static int nextOrderItemId = 1;

    private final int orderItemId;

    private final String orderedItemName;
    private final double orderedItemPrice;
    private final int orderedItemQuantity;

    public OrderItem(MenuItem item, int quantity) {

        if(item == null)
            throw new IllegalArgumentException("MenuItem cannot be null.");

        if(quantity <= 0)
            throw new IllegalArgumentException("Quantity must be positive.");

        this.orderItemId = nextOrderItemId++;
        this.orderedItemName = item.getMenuItemName();
        this.orderedItemPrice = item.getPrice();
        this.orderedItemQuantity = quantity;
    }

    public int getOrderItemId(){ return orderItemId; }

    public String getOrderedItemName(){ return orderedItemName; }

    public double getOrderedItemPrice(){ return orderedItemPrice; }

    public int getOrderedItemQuantity(){ return orderedItemQuantity; }

    @Override
    public String toString(){
        return orderedItemName +
                " x" + orderedItemQuantity +
                " ₹" + orderedItemPrice;
    }
}