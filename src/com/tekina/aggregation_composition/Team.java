package com.tekina.aggregation_composition;

import java.util.ArrayList;
import java.util.List;

public class Team {
    /*
     * Generated Fields:
     * - teamId
     *
     * Mandatory Fields:
     * - teamName
     *
     * Internally Managed Fields:
     * - players
     *
     * Optional Fields:
     * - None
     *
     * Mutable Fields:
     * - teamName
     * - players
     *
     * Immutable Fields:
     * - teamId
     *
     * Relationship Type:
     * - Aggregation
     *
     * Why?
     * - Team HAS-A List<Player>.
     * - Players are created outside the Team.
     * - Players can exist before joining a Team.
     * - Players continue to exist even if the Team is deleted.
     */
    private static int id = 1;
    private final int teamId;
    private String teamName;
    private List<Player> players;

    public Team(String teamName, List<Player> players){
        if(teamName == null || teamName.isBlank()){
            throw new IllegalArgumentException("Team Name can not be empty or NULL.");
        }
        this.teamId = id++;
        this.teamName = teamName;
        this.players = players == null ? new ArrayList<>() : new ArrayList<>(players);
    }

    public Team(String teamName){
        this(teamName, null);
    }

    public boolean addPlayer(Player player){
        return this.players.add(player);
    }

    public boolean removePlayer(int playerId){
        Player playerToRemove = null;
        for(Player player : this.players){
            if(player.getPlayerId() == playerId){
                playerToRemove = player;
                break;
            }
        }
        if(playerToRemove == null){
            System.out.println("Can not find any player with this id");
            return false;
        }
        return this.players.remove(playerToRemove);
    }

    public void displayPlayers(){
        for(Player player: this.players){
            System.out.println(player);
        }
    }

    @Override
    public String toString(){
        return ("Team Id : " + this.teamId + "| Team name : " + this.teamName + "| Players : " + this.players);
    }
}
