package com.tekina.foodDeliverySystem;

import java.util.ArrayList;
import java.util.List;

public class FoodDeliveryApp {

    // Generated : appId

    // Mandatory : name, tagLine

    // Optional : about, customers (Customer), restaurants (Restaurant),
    // deliveryPartners (DeliveryPartner), orders (Order)

    // Mutable : name, about

    // Immutable : appId

    private static int nextAppId = 1;

    private final int appId;

    private String name;
    private String tagLine;
    private String about;

    private final List<Customer> customers;
    private final List<Restaurant> restaurants;
    private final List<Order> orders;
    private final List<DeliveryPartner> deliveryPartners;

    public FoodDeliveryApp(String name,
                           String tagLine) {

        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Invalid app name.");
        }

        if(tagLine == null || tagLine.isEmpty()){
            throw new IllegalArgumentException("Invalid tagline.");
        }

        this.appId = nextAppId++;
        this.name = name;
        this.tagLine = tagLine;

        this.customers = new ArrayList<>();
        this.restaurants = new ArrayList<>();
        this.deliveryPartners = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    private Customer findCustomer(int customerId){
        for(Customer customer : customers){
            if(customer.getCustomerId() == customerId){
                return customer;
            }
        }
        return null;
    }

    private Restaurant findRestaurant(int restaurantId){
        for(Restaurant restaurant : restaurants){
            if(restaurant.getRestaurantId() == restaurantId){
                return restaurant;
            }
        }
        return null;
    }

    private DeliveryPartner findPartner(int partnerId){
        for(DeliveryPartner partner : deliveryPartners){
            if(partner.getPartnerId() == partnerId){
                return partner;
            }
        }
        return null;
    }

    private Order findOrder(int orderId){
        for(Order order : orders){
            if(order.getOrderId() == orderId){
                return order;
            }
        }
        return null;
    }

    public boolean registerCustomer(Customer customer){

        if(customer == null){
            return false;
        }

        customers.add(customer);
        return true;
    }

    public boolean registerRestaurant(Restaurant restaurant){

        if(restaurant == null){
            return false;
        }

        restaurants.add(restaurant);
        return true;
    }

    public boolean registerDeliveryPartner(DeliveryPartner partner){

        if(partner == null){
            return false;
        }

        deliveryPartners.add(partner);
        return true;
    }

    public Order placeOrder(Customer customer,
                            Restaurant restaurant){

        if(customer == null || restaurant == null){
            return null;
        }

        if(customer.getCustomerCart().getCartItems().isEmpty()){
            return null;
        }

        Order order = new Order(
                customer,
                restaurant,
                customer.getCustomerCart()
        );

        orders.add(order);

        customer.addOrder(order);

        customer.getCustomerCart().clear();

        return order;
    }

    public boolean assignDeliveryPartner(int orderId,
                                         int partnerId){

        Order order = findOrder(orderId);
        DeliveryPartner partner = findPartner(partnerId);

        if(order == null || partner == null){
            return false;
        }

        return order.assignDeliveryPartner(partner);
    }

    public boolean cancelOrder(int orderId){

        Order order = findOrder(orderId);

        if(order == null){
            return false;
        }

        return order.updateStatus("CANCELLED");
    }

    public void displayRestaurants(){

        for(Restaurant restaurant : restaurants){
            System.out.println(restaurant);
        }
    }

    public void displayOrders(){

        for(Order order : orders){
            System.out.println(order);
        }
    }

}