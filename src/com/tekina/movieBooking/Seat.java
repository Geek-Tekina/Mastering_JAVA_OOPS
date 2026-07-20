package com.tekina.movieBooking;
public class Seat {

    private static int nextSeatId = 1;

    private final int seatId;
    private final int seatNumber;

    private Booking bookedBy;

    public Seat(int seatNumber){
        if(seatNumber <= 0){
            throw new IllegalArgumentException("Seat number can not be negative");
        }
        this.seatId = nextSeatId++;
        this.seatNumber = seatNumber;
        this.bookedBy = null;
    }

    public boolean isAvailable(){
        return this.bookedBy == null;
    }

    public boolean book(Booking booking){

        if(booking == null){
            return false;
        }

        if(!isAvailable()){
            return false;
        }

        bookedBy = booking;
        return true;
    }

    public boolean release(){
        this.bookedBy = null;
        return true;
    }

    public int getSeatId(){
        return this.seatId;
    }

    public int getSeatNumber(){
        return this.seatNumber;
    }

    public Booking getBookedBy(){
        return this.bookedBy;
    }

    @Override
    public String toString() {

        return "Seat{" +
                "seatId=" + seatId +
                ", seatNumber=" + seatNumber +
                ", status=" +
                (bookedBy == null ? "Available" : "Booked") +
                '}';
    }
}