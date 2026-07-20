package com.tekina.movieBooking;

import java.util.List;

public class Theatre {

    private static int nextTheatreId = 1;

    private final int theatreId;

    private String name;
    private String location;

    private final List<Show> shows;

    private final List<Booking> bookings;

}