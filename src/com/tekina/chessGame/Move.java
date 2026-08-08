package com.tekina.chessGame;

public class Move {

    // Generated:
    // None

    // Mandatory:
    // movedPiece, fromPosition, toPosition

    // Optional:
    // capturedPiece, promotedPiece

    // Mutable:
    // None

    // Immutable:
    // movedPiece, fromPosition, toPosition,
    // capturedPiece, promotedPiece

    private final Piece movedPiece;
    private final Position fromPosition;
    private final Position toPosition;

    private final Piece capturedPiece;
    private final Piece promotedPiece;

    public Move(
            Piece movedPiece,
            Position fromPosition,
            Position toPosition,
            Piece capturedPiece,
            Piece promotedPiece) {
        // validation + initialization later
    }

    public Piece getMovedPiece() {
        return null;
    }

    public Position getFromPosition() {
        return null;
    }

    public Position getToPosition() {
        return null;
    }

    public Piece getCapturedPiece() {
        return null;
    }

    public Piece getPromotedPiece() {
        return null;
    }
}