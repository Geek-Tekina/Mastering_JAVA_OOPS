package com.tekina.aggregation_composition;

public class Room {
    /*
     * Generated Fields:
     * - roomNumber
     *
     * Mandatory Fields:
     * - roomType
     *
     * Optional Fields:
     * - None
     *
     * Mutable Fields:
     * - roomType
     *
     * Immutable Fields:
     * - roomNumber
     *
     * Relationship Type:
     * - Composition (Child Entity)
     *
     * Why?
     * - A Room is intended to exist as part of a House.
     * - Its lifecycle is controlled by House.
     * - Rooms lose meaning without their parent House.
     */
    private static int number = 1;
    private final int roomNumber;
    private String roomType;

    public Room(String roomType){
        if(roomType == null || roomType.isBlank()){
            throw new IllegalArgumentException("Room Type Can not be null or blank.");
        }
        this.roomNumber = number++;
        this.roomType = roomType;
    }

    @Override
    public String toString(){
        return ("Room Number : " + this.roomNumber + "| Room Type : " + this.roomType);
    }
}
