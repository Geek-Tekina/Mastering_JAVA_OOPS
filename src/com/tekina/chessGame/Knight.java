package com.tekina.chessGame;

public class Knight extends Piece {

    public Knight(Color color, Position currentPosition) {
        super(color, currentPosition, PieceType.KNIGHT);
    }

    @Override
    public boolean canMove(Position from, Position to) {

        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getColumn() - from.getColumn());

        return (rowDiff == 2 && colDiff == 1)
                || (rowDiff == 1 && colDiff == 2);
    }
}