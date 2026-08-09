package com.tekina.chessGame;

public class Player {

    // Generated:
    // playerId

    // Mandatory:
    // name, color

    // Optional:
    // None

    // Mutable:
    // name

    // Immutable:
    // playerId, color

    private static int idGenerator = 1;

    private final int playerId;
    private final Color color;

    private String name;

    public Player(String name, Color color) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Player name cannot be empty"
            );
        }

        if (color == null) {
            throw new IllegalArgumentException(
                    "Player color cannot be null"
            );
        }

        this.playerId = idGenerator++;
        this.name = name;
        this.color = color;
    }

    public int getPlayerId() {
        return this.playerId;
    }

    public String getName() {
        return this.name;
    }

    public Color getColor() {
        return this.color;
    }

    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Player name cannot be empty"
            );
        }

        this.name = name;
    }

    @Override
    public String toString() {

        return "Player{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                ", color=" + color +
                '}';
    }
}