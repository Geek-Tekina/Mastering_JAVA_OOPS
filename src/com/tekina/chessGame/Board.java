package com.tekina.chessGame;

public class Board {

    // Generated: grid(Square[][])
    // Mandatory:
    // Optional:
    // Mutable: grid contents
    // Immutable: grid reference

    private final Square[][] grid;

    private void createGrid() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                this.grid[i][j] =
                        new Square(new Position(i + 1, j + 1));
            }
        }
    }

    private void placePawns(Color color) {

        int row = color == Color.WHITE ? 1 : 6;

        for (int i = 0; i < 8; ++i) {

            Position position =
                    new Position(row + 1, i + 1);

            this.grid[row][i].placePiece(
                    new Pawn(color, position)
            );
        }
    }

    private void placeInitialRow(Color color) {

        int row = color == Color.WHITE ? 0 : 7;

        this.grid[row][0].placePiece(
                new Rook(color, new Position(row + 1, 1))
        );

        this.grid[row][1].placePiece(
                new Knight(color, new Position(row + 1, 2))
        );

        this.grid[row][2].placePiece(
                new Bishop(color, new Position(row + 1, 3))
        );

        this.grid[row][3].placePiece(
                new Queen(color, new Position(row + 1, 4))
        );

        this.grid[row][4].placePiece(
                new King(color, new Position(row + 1, 5))
        );

        this.grid[row][5].placePiece(
                new Bishop(color, new Position(row + 1, 6))
        );

        this.grid[row][6].placePiece(
                new Knight(color, new Position(row + 1, 7))
        );

        this.grid[row][7].placePiece(
                new Rook(color, new Position(row + 1, 8))
        );
    }

    private void placePieces() {

        placePawns(Color.WHITE);
        placePawns(Color.BLACK);

        placeInitialRow(Color.WHITE);
        placeInitialRow(Color.BLACK);
    }

    public Board() {
        this.grid = new Square[8][8];

        createGrid();
        placePieces();
    }

    public Square getSquare(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }

        if (position.getRow() < 1 || position.getRow() > 8
                || position.getColumn() < 1 || position.getColumn() > 8) {
            throw new IllegalArgumentException("Position must be between 1 and 8");
        }

        return this.grid[
                position.getRow() - 1
                ][
                position.getColumn() - 1
                ];
    }

    public boolean isValidMove(Position from, Position to) {
        return false;
    }

    public boolean move(Position from, Position to) {
        return false;
    }

    public void display() {
        // later
    }

    @Override
    public String toString() {
        return "Board{" +
                "grid=" + java.util.Arrays.deepToString(grid) +
                '}';
    }
}