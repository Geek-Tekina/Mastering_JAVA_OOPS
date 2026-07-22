package com.tekina.movieBooking;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Theatre theatre = new Theatre(
                "PVR Phoenix Mall",
                "Whitefield"
        );

        Movie movie = new Movie(
                "Interstellar",
                "Sci-Fi",
                169
        );

        Show show = theatre.createShow(
                movie,
                1800,      // 6:00 PM
                10         // Total Seats
        );

        Customer aniket = new Customer(
                "Aniket",
                "aniket@gmail.com"
        );

        System.out.println("========= SHOWS =========");
        theatre.displayShows();

        System.out.println();

        System.out.println("========= BOOKING =========");

        Booking booking = theatre.bookSeats(
                aniket,
                show.getShowId(),
                Arrays.asList(2, 3, 5)
        );

        if (booking != null) {
            System.out.println("Booking Successful!");
            System.out.println(booking);
        }

        System.out.println();

        System.out.println("========= ACTIVE BOOKINGS =========");

        theatre.displayBookings();

        System.out.println();

        System.out.println("========= CANCEL =========");

        theatre.cancelBooking(
                booking.getBookingId()
        );

        theatre.displayBookings();

        System.out.println();

        System.out.println("========= CUSTOMER HISTORY =========");

        for (Booking b : aniket.getBookings()) {
            System.out.println(b);
        }
    }
}