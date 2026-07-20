package com.tekina.movieBooking;

import java.util.List;

public class Show {

    private static int nextShowId = 1;

    private final int showId;

    private final List<Seat> seats;

    private final Movie movie;

    private final int startTime;
    private final int endTime;

}