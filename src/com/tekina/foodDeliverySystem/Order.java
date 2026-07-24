package com.tekina.foodDeliverySystem;

import java.util.Date;
import java.util.List;

public class Order {

    // Generated : orderId, orderedTime, orderItems (OrderItem), orderStatus

    // Mandatory : customer (Customer), restaurant (Restaurant)

    // Optional : deliveryPartner (DeliveryPartner)

    // Mutable : orderStatus, deliveryPartner

    // Immutable : orderId, orderedTime, customer, restaurant, orderItems

    private static int nextOrderId = 1;

    private final int orderId;

    private final Date orderedTime;

    private final Customer customer;

    private final Restaurant restaurant;

    private DeliveryPartner deliveryPartner;

    private final List<OrderItem> orderItems;

    private String orderStatus;
}