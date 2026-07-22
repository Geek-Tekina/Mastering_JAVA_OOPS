package com.tekina.movieBooking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Booking {

    private static int nextBookingId = 1;

    private final int bookingId;

    private String bookingStatus;

    private final Date bookingTime;

    private final Customer customer;

    private final Show show;

    private final List<Seat> bookedSeats;

    public Booking(Customer customer, Show show, List<Seat> bookedSeats){
        if(customer == null || show == null || bookedSeats == null){
            throw new IllegalArgumentException("Customer, show or bookedSeats can not be NULL.");
        }
        this.bookingId = nextBookingId++;
        this.bookingStatus = "ACTIVE";
        this.bookingTime = new Date();
        this.customer = customer;
        this.show = show;
        this.bookedSeats = new ArrayList<>(bookedSeats);    }

    public boolean cancel(){
        if(Objects.equals(this.bookingStatus, "CANCELLED")){
            return false;
        }
        this.bookingStatus = "CANCELLED";
        return true;
    }

    public boolean isCancelled(){
        return Objects.equals(this.bookingStatus, "CANCELLED");
    }

    public int getBookingId() {
        return bookingId;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public Show getShow() {
        return show;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", customer=" + customer.getName() +
                ", status='" + bookingStatus + '\'' +
                ", seats=" + bookedSeats.size() +
                ", bookingTime=" + bookingTime +
                '}';
    }
}