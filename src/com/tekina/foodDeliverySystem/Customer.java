package com.tekina.foodDeliverySystem;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    // Generated : customerId, cart(Cart)

    // Mandatory : name, email, phoneNumber

    // Optional : gender, address, orders (Order)

    // Mutable : name, email, phoneNumber, gender, address

    // Immutable : customerId, cart

    private static int nextCustomerId = 1;

    private final int customerId;

    private final Cart customerCart;

    private String customerName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String address;

    private final List<Order> orders; // history

    public Customer(String customerName,
                    String email,
                    String phoneNumber) {

        if(customerName == null || customerName.isEmpty()){
            throw new IllegalArgumentException("Customer name cannot be null or empty.");
        }

        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }

        if(phoneNumber == null || phoneNumber.isEmpty()){
            throw new IllegalArgumentException("Phone number cannot be null or empty.");
        }

        this.customerId = nextCustomerId++;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;

        this.customerCart = new Cart();
        this.orders = new ArrayList<>();
    }

    public boolean addOrder(Order order){

        if(order == null){
            return false;
        }

        this.orders.add(order);
        return true;
    }

    public boolean removeOrder(Order order){

        if(order == null){
            return false;
        }

        return this.orders.remove(order);
    }

    public int getCustomerId() {
        return customerId;
    }

    public Cart getCustomerCart() {
        return customerCart;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setCustomerName(String customerName) {

        if(customerName == null || customerName.isEmpty()){
            throw new IllegalArgumentException("Customer name cannot be null or empty.");
        }

        this.customerName = customerName;
    }

    public void setEmail(String email) {

        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }

        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {

        if(phoneNumber == null || phoneNumber.isEmpty()){
            throw new IllegalArgumentException("Phone number cannot be null or empty.");
        }

        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {

        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", cartItems=" + customerCart.getCartItems().size() +
                ", totalOrders=" + orders.size() +
                '}';
    }
}