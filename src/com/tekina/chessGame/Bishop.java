package com.tekina.chessGame;

public class Bishop extends Piece {

    public Bishop(Color color, Position currentPosition) {
        super(color, currentPosition, PieceType.BISHOP);
    }

    @Override
    public boolean canMove(Position from, Position to) {

        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getColumn() - from.getColumn());

        return rowDiff == colDiff && rowDiff != 0;
    }
}