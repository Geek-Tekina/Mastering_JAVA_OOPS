package com.tekina.chessGame;

public class Rook extends Piece {

    public Rook(Color color, Position currentPosition) {
        super(color, currentPosition, PieceType.ROOK);
    }

    @Override
    public boolean canMove(Position from, Position to) {

        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getColumn() - from.getColumn());

        return (rowDiff == 0 || colDiff == 0)
                && (rowDiff != 0 || colDiff != 0);
    }
}