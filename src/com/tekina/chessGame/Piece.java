package com.tekina.chessGame;

public abstract class Piece {

    // Generated: isCaptured = false
    // Mandatory: color, currentPosition, pieceType
    // Optional:
    // Mutable: currentPosition, isCaptured
    // Immutable: color, pieceType

    private final Color color;
    private final PieceType pieceType;

    private Position currentPosition;
    private boolean isCaptured;

    public Piece(Color color, Position currentPosition, PieceType pieceType) {
        if(color == null || currentPosition == null || pieceType == null){
            throw new IllegalArgumentException("Wrong Arguments");
        }
        this.color = color;
        this.currentPosition = currentPosition;
        this.pieceType = pieceType;
        this.isCaptured = false;
    }

    // Movement Abstract contract
    public abstract boolean canMove(Position from, Position to);

    public Color getColor() {
        return this.color;
    }

    public PieceType getPieceType() {
        return this.pieceType;
    }

    public Position getCurrentPosition() {
        return this.currentPosition;
    }

    public boolean isCaptured() {
        return this.isCaptured;
    }

    void moveTo(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }

        this.currentPosition = position;
    }        // Board-controlled mutation

    void markCaptured(){
        this.isCaptured = true;
    }                  // Board-controlled mutation

    @Override
    public String toString() {

        return "Piece{" +
                "color=" + color +
                ", pieceType=" + pieceType +
                ", currentPosition=" + currentPosition +
                ", isCaptured=" + isCaptured +
                '}';
    }
}