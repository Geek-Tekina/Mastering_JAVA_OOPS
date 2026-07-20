package com.tekina.movieBooking;

import java.util.Date;
import java.util.List;

public class Booking {

    private static int nextBookingId = 1;

    private final int bookingId;

    private String bookingStatus;

    private final Date bookingTime;

    private final Customer customer;

    private final Show show;

    private final List<Seat> bookedSeats;

}