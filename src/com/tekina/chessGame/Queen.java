package com.tekina.chessGame;

public class Queen extends Piece {

    public Queen(Color color, Position currentPosition) {
        super(color, currentPosition, PieceType.QUEEN);
    }

    @Override
    public boolean canMove(Position from, Position to) {

        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getColumn() - from.getColumn());

        return (rowDiff == colDiff || rowDiff == 0 || colDiff == 0)
                && (rowDiff != 0 || colDiff != 0);
    }
}