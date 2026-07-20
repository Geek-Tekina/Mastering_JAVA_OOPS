package com.tekina.movieBooking;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static int nextCustomerId = 1;

    private final int customerId;

    private String name;
    private String email;

    private final List<Booking> bookings; // this is a mere history for customer view side

    public Customer(String name, String email){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name can not be null or empty");
        }
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Name can not be null or empty");
        }
        this.customerId = nextCustomerId++;
        this.name = name;
        this.email = email;
        this.bookings = new ArrayList<Booking>();
    }

    public String getEmail() {
        return email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public String getName() {
        return name;
    }

    public boolean addBooking(Booking booking){
        if(booking == null) return false;
        this.bookings.add(booking);
        return true;
    }

    public boolean removeBooking(Booking booking){
        if(booking == null){
            return false;
        }
        return bookings.remove(booking);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", bookings=" + bookings.size() +
                '}';
    }

}