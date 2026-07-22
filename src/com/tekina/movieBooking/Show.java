package com.tekina.movieBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Show {

    private static int nextShowId = 1;

    private final int showId;

    private final Map<Integer, Seat> seats;

    private final Movie movie;

    private final int startTime;
    private final int endTime;

    public Show(int startTime, int seatCount, Movie movie) {

        if (movie == null) {
            throw new IllegalArgumentException("Movie cannot be null.");
        }

        if (startTime < 0) {
            throw new IllegalArgumentException("Invalid start time.");
        }

        if (seatCount <= 0) {
            throw new IllegalArgumentException("Seat count must be greater than zero.");
        }

        this.showId = nextShowId++;
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = startTime + movie.getDurationInMinutes();

        this.seats = new HashMap<>();

        for (int i = 1; i <= seatCount; i++) {
            this.seats.put(i, new Seat(i));
        }
    }

    public boolean areSeatsAvailable(List<Integer> seatNumbers) {

        if (seatNumbers == null || seatNumbers.isEmpty()) {
            return false;
        }

        for (Integer seatNumber : seatNumbers) {

            Seat seat = seats.get(seatNumber);

            if (seat == null || !seat.isAvailable()) {
                return false;
            }
        }

        return true;
    }

    public List<Seat> getSeats(List<Integer> seatNumbers) {

        List<Seat> bookedSeats = new ArrayList<>();

        for (Integer seatNumber : seatNumbers) {

            Seat seat = seats.get(seatNumber);

            if (seat == null) {
                throw new IllegalArgumentException(
                        "Invalid seat number : " + seatNumber);
            }

            bookedSeats.add(seat);
        }

        return bookedSeats;
    }

    public boolean bookSeats(Booking booking) {

        if (booking == null) {
            return false;
        }

        for (Seat seat : booking.getBookedSeats()) {

            if (!seat.book(booking)) {
                return false;
            }
        }

        return true;
    }

    public boolean releaseSeats(Booking booking) {

        if (booking == null) {
            return false;
        }

        for (Seat seat : booking.getBookedSeats()) {
            seat.release();
        }

        return true;
    }

    public int getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {

        return "Show{" +
                "showId=" + showId +
                ", movie=" + movie.getMovieName() +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", totalSeats=" + seats.size() +
                '}';
    }
}