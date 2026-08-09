package com.tekina.chessGame;

public class Square {

    // Generated: position
    // Mandatory:
    // Optional: piece
    // Mutable: piece
    // Immutable: position

    private final Position position;
    private Piece piece;

    public Square(Position position) {
        if(position == null) throw new IllegalArgumentException("Position can not be NULL");
        this.position = position;
        this.piece = null;
    }

    public Position getPosition() {
        return this.position;
    }

    public Piece getPiece() {
        if(this.piece != null){
            return this.piece;
        }
        return null;
    }

    public boolean isOccupied() {
        return this.piece != null;
    }

    boolean placePiece(Piece piece) {
        if (piece == null) {
            throw new IllegalArgumentException("Piece cannot be null");
        }
        if(this.isOccupied()){
            return false;
        }
        this.piece = piece;
        return true;
    }

    void removePiece() {
        this.piece = null;
    }

    @Override
    public String toString() {

        return "Square{" +
                "position=" + position +
                ", piece=" + piece +
                '}';
    }
}