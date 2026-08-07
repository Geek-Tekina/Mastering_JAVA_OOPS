package com.tekina.foodDeliverySystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static int nextOrderId = 1;

    private final int orderId;

    private final List<OrderItem> orderItems;

    private final Date orderedTime;

    private final Customer customer;

    private final Restaurant restaurant;

    private DeliveryPartner deliveryPartner;

    private String orderStatus;

    public Order(Customer customer,
                 Restaurant restaurant,
                 Cart cart){

        if(customer == null || restaurant == null || cart == null)
            throw new IllegalArgumentException();

        this.orderId = nextOrderId++;
        this.customer = customer;
        this.restaurant = restaurant;
        this.orderedTime = new Date();
        this.orderStatus = "PLACED";

        this.orderItems = new ArrayList<>();

        for(CartItem item : cart.getCartItems()){
            orderItems.add(
                    new OrderItem(
                            item.getMenuItem(),
                            item.getQuantity()
                    )
            );
        }
    }

    public boolean assignDeliveryPartner(DeliveryPartner partner){

        if(partner == null)
            return false;

        this.deliveryPartner = partner;
        return true;
    }

    public boolean updateStatus(String status){

        if(status == null || status.isBlank())
            return false;

        this.orderStatus = status;
        return true;
    }

    public double calculateTotal(){

        double total = 0;

        for(OrderItem item : orderItems){

            total += item.getOrderedItemPrice()
                    * item.getOrderedItemQuantity();
        }

        return total;
    }

    public int getOrderId(){ return orderId; }

    public Customer getCustomer(){ return customer; }

    public Restaurant getRestaurant(){ return restaurant; }

    public List<OrderItem> getOrderItems(){ return orderItems; }

    public String getOrderStatus(){ return orderStatus; }

    @Override
    public String toString(){

        return "Order #" + orderId +
                " | " + customer.getCustomerName() +
                " | ₹" + calculateTotal() +
                " | " + orderStatus;
    }
}