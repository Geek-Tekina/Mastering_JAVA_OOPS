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

        if (movedPiece == null
                || fromPosition == null
                || toPosition == null) {

            throw new IllegalArgumentException(
                    "Moved piece and positions cannot be null"
            );
        }

        this.movedPiece = movedPiece;
        this.fromPosition = fromPosition;
        this.toPosition = toPosition;
        this.capturedPiece = capturedPiece;
        this.promotedPiece = promotedPiece;
    }

    public Piece getMovedPiece() {
        return this.movedPiece;
    }

    public Position getFromPosition() {
        return this.fromPosition;
    }

    public Position getToPosition() {
        return this.toPosition;
    }

    public Piece getCapturedPiece() {
        return this.capturedPiece;
    }

    public Piece getPromotedPiece() {
        return this.promotedPiece;
    }

    @Override
    public String toString() {

        return "Move{" +
                "movedPiece=" + movedPiece +
                ", fromPosition=" + fromPosition +
                ", toPosition=" + toPosition +
                ", capturedPiece=" + capturedPiece +
                ", promotedPiece=" + promotedPiece +
                '}';
    }
}