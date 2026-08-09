package com.tekina.chessGame;

import java.util.Objects;

public class Position {

    // Generated:
    // None

    // Mandatory:
    // row, column

    // Optional:
    // None

    // Mutable:
    // None

    // Immutable:
    // row, column

    private final int row;
    private final int column;

    public Position(int row, int column) {

        if (row < 1 || row > 8 ||
                column < 1 || column > 8) {

            throw new IllegalArgumentException(
                    "Row and column must be between 1 and 8"
            );
        }

        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Position)) {
            return false;
        }

        Position other = (Position) obj;

        return this.row == other.row
                && this.column == other.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "(" + row + "," + column + ")";
    }
}