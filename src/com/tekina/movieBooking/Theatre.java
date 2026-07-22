package com.tekina.movieBooking;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private static int nextTheatreId = 1;

    private final int theatreId;

    private String name;
    private String location;

    private final List<Show> shows;

    private final List<Booking> bookings;

    public Theatre(String name, String location){

        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid theatre name.");
        }

        if(location == null || location.isBlank()){
            throw new IllegalArgumentException("Invalid location.");
        }

        this.theatreId = nextTheatreId++;
        this.name = name;
        this.location = location;

        this.shows = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    private Show findShow(int showId){

        for(Show show : shows){
            if(show.getShowId() == showId){
                return show;
            }
        }

        return null;
    }

    private Booking findBooking(int bookingId){

        for(Booking booking : bookings){
            if(booking.getBookingId() == bookingId){
                return booking;
            }
        }

        return null;
    }

    private void addBooking(Booking booking){
        bookings.add(booking);
    }

    private boolean removeBooking(Booking booking){
        return bookings.remove(booking);
    }

    public Show createShow(Movie movie,
                           int startTime,
                           int seatCount){

        Show show = new Show(startTime,
                seatCount,
                movie);

        shows.add(show);

        return show;
    }

    public boolean removeShow(int showId){

        Show show = findShow(showId);

        if(show == null){
            return false;
        }

        return shows.remove(show);
    }

    public Booking bookSeats(Customer customer,
                             int showId,
                             List<Integer> seatNumbers){

        if(customer == null || seatNumbers == null || seatNumbers.isEmpty()){
            return null;
        }

        Show show = findShow(showId);

        if(show == null){
            System.out.println("Show not found.");
            return null;
        }

        if(!show.areSeatsAvailable(seatNumbers)){
            System.out.println("Requested seats are not available.");
            return null;
        }

        List<Seat> seats = show.getSeats(seatNumbers);

        Booking booking = new Booking(customer,
                show,
                seats);

        if(!show.bookSeats(booking)){
            return null;
        }

        customer.addBooking(booking);

        addBooking(booking);

        return booking;
    }

    public boolean cancelBooking(int bookingId){

        Booking booking = findBooking(bookingId);

        if(booking == null){
            return false;
        }

        if(!booking.cancel()){
            return false;
        }

        booking.getShow().releaseSeats(booking);

        removeBooking(booking);

        return true;
    }

    public void displayShows(){

        for(Show show : shows){
            System.out.println(show);
        }
    }

    public void displayBookings(){

        for(Booking booking : bookings){
            System.out.println(booking);
        }
    }

    @Override
    public String toString(){

        return "Theatre{" +
                "theatreId=" + theatreId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", shows=" + shows.size() +
                ", activeBookings=" + bookings.size() +
                '}';
    }
}