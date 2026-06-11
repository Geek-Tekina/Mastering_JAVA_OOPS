package com.tekina.aggregation_composition;

import java.util.ArrayList;
import java.util.List;

public class House {
    /*
     * Generated Fields:
     * - houseId
     *
     * Mandatory Fields:
     * - ownerName
     *
     * Internally Managed Fields:
     * - rooms
     *
     * Optional Fields:
     * - None
     *
     * Mutable Fields:
     * - ownerName
     * - rooms
     *
     * Immutable Fields:
     * - houseId
     *
     * Relationship Type:
     * - Composition
     *
     * Why?
     * - House HAS-A List<Room>.
     * - House creates Room objects internally.
     * - Rooms cannot be supplied from outside.
     * - If the House ceases to exist, its Rooms cease to exist as well.
     */

    private static int id = 1000;
    private final int houseId;
    private String ownerName;
    private List<Room> rooms;

    public House(String ownerName, String[] rooms){
        if(ownerName == null || ownerName.isBlank()){
            throw new IllegalArgumentException("House owner name can not be blank or null");
        }
        if(rooms != null && rooms.length > 0){
            ArrayList<Room> roomsToAdd = new ArrayList<>();
            for(String roomType : rooms){
                Room newRoom = new Room(roomType);
                roomsToAdd.add(newRoom);
            }
            this.rooms = roomsToAdd;
        }else{
            this.rooms = new ArrayList<Room>();
        }
        this.houseId = id++;
        this.ownerName = ownerName;
    }

    public House(String ownerName){
        this(ownerName, null);
    }
    public void addRoom(String roomType){
        if(roomType == null || roomType.isBlank()){
            System.out.println("RoomType can not be empty");
            return;
        }
        Room newRoom = new Room(roomType);
        this.rooms.add(newRoom);
    }

    public void displayRooms(){
        for(Room room : this.rooms){
            System.out.println(room);
        }
    }

    @Override
    public String toString(){
        return ("House Id : " + this.houseId + "House Owner's Name : " + this.ownerName + "House Rooms : " + this.rooms);
    }
}
