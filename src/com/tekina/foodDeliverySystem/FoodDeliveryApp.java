package com.tekina.foodDeliverySystem;

import java.util.List;

public class FoodDeliveryApp {

    // Generated : appId

    // Mandatory : name, tagLine

    // Optional : about, customers (Customer), restaurants (Restaurant),
    // deliveryPartners (DeliveryPartner), orders (Order)

    // Mutable : name, tagLine, about

    // Immutable : appId

    private static int nextAppId = 1;

    private final int appId;

    private String name;
    private String tagLine;
    private String about;

    private List<Customer> customers;
    private List<Restaurant> restaurants;
    private List<DeliveryPartner> deliveryPartners;
    private List<Order> orders;
}