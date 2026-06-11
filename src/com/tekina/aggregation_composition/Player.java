package com.tekina.aggregation_composition;

public class Player {
    /*
     * Generated Fields:
     * - playerId
     *
     * Mandatory Fields:
     * - name
     *
     * Optional Fields:
     * - position
     *
     * Mutable Fields:
     * - name
     * - position
     *
     * Immutable Fields:
     * - playerId
     *
     * Relationship Type:
     * - None (Independent Entity)
     *
     * Why?
     * - A Player can exist independently.
     * - A Player may or may not belong to a Team.
     */
    private static int id = 1;
    private final int playerId;
    private String name;
    private String position;

    public Player(String name, String position){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Player Name can not be empty or NULL.");
        }
        this.playerId = id++;
        this.position = position;
        this.name = name;
    }

    public Player(String name){
        this(name, "Unnassigned");
    }

    public int getPlayerId() {
        return playerId;
    }

    @Override
    public String toString(){
        return ("Player Id : " + this.playerId + "| Player Name : " + this.name + "| Player Position : " + this.position);
    }
}
