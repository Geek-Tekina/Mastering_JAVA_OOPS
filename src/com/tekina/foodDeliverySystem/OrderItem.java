package com.tekina.foodDeliverySystem;

public class OrderItem {

    // Generated : orderItemId

    // Mandatory : menuItemId

    // Optional : (we will accept MenuItem to create -> name, price and other related info)
    // orderedItemName, orderedItemPrice, orderedItemQuantity

    // Mutable :

    // Immutable : orderItemId

    private static int nextOrderItemId = 1;

    private final int orderItemId;

    private final int menuItemId;

    private final String orderedItemName;
    private final double orderedItemPrice;
    private final int orderedItemQuantity;
}