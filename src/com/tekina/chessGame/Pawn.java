package com.tekina.chessGame;

public class Pawn extends Piece {

    public Pawn(Color color, Position currentPosition) {
        super(color, currentPosition, PieceType.PAWN);
    }

    @Override
    public boolean canMove(Position from, Position to) {

        // WHITE -> increasing row
        // BLACK -> decreasing row
        int direction = getColor() == Color.WHITE ? 1 : -1;

        int rowDiff = to.getRow() - from.getRow();
        int colDiff = Math.abs(to.getColumn() - from.getColumn());

        // V1: straight movement only.
        // Diagonal capture will be handled later.
        if (colDiff != 0) {
            return false;
        }

        // One square forward
        if (rowDiff == direction) {
            return true;
        }

        // Two squares from the initial position
        return rowDiff == 2 * direction
                && isInitialPosition(from);
    }

    private boolean isInitialPosition(Position position) {

        return (getColor() == Color.WHITE && position.getRow() == 2)
                || (getColor() == Color.BLACK && position.getRow() == 7);
    }
}