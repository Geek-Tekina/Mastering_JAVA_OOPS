package com.tekina.movieBooking;

import java.util.Arrays;

public class Movie {

    private static int nextMovieId = 1;

    private final int movieId;

    private final String movieName;
    private final String genre;
    private final int durationInMinutes;

    private final String[] cast;
    private final String productionHouse;

    public Movie(String movieName,
                 String genre,
                 int durationInMinutes,
                 String[] cast,
                 String productionHouse) {

        if (movieName == null || movieName.isBlank()) {
            throw new IllegalArgumentException("Movie name cannot be null or blank.");
        }

        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Genre cannot be null or blank.");
        }

        if (durationInMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be greater than zero.");
        }

        this.movieId = nextMovieId++;
        this.movieName = movieName;
        this.genre = genre;
        this.durationInMinutes = durationInMinutes;
        this.cast = cast;
        this.productionHouse = productionHouse;
    }

    public Movie(String movieName,
                 String genre,
                 int durationInMinutes) {

        this(movieName,
                genre,
                durationInMinutes,
                null,
                "");
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getGenre() {
        return genre;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public String[] getCast() {
        return cast;
    }

    public String getProductionHouse() {
        return productionHouse;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + durationInMinutes + " mins" +
                ", productionHouse='" + productionHouse + '\'' +
                ", cast=" + (cast == null ? "N/A" : Arrays.toString(cast)) +
                '}';
    }
}