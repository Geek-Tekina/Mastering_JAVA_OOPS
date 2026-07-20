package com.tekina.movieBooking;
public class Movie {

    private static int nextMovieId = 1;

    private final int movieId;

    private final String movieName;
    private final String genre;
    private final int durationInMinutes;

    private String[] cast;
    private String productionHouse;

}