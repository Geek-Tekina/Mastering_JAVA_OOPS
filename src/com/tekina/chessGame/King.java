package com.tekina.chessGame;

public class King extends Piece {

    public King(Color color, Position currentPosition) {
        super(color, currentPosition, PieceType.KING);
    }

    @Override
    public boolean canMove(Position from, Position to) {

        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getColumn() - from.getColumn());

        return rowDiff <= 1
                && colDiff <= 1
                && (rowDiff != 0 || colDiff != 0);
    }
}