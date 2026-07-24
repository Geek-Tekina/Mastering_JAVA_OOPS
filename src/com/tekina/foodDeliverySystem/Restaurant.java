package com.tekina.foodDeliverySystem;

public class Restaurant {

    // Generated : restaurantId, restaurantMenu (Menu)

    // Mandatory : name, location

    // Optional :

    // Mutable : name, location

    // Immutable : restaurantId, restaurantMenu

    private static int nextRestaurantId = 1;

    private final int restaurantId;

    private final Menu restaurantMenu;

    private String name;
    private String location;
}