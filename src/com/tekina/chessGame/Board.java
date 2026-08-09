package com.tekina.chessGame;

public class Board {

    // Generated: grid(Square[][])
    // Mandatory:
    // Optional:
    // Mutable: grid contents
    // Immutable: grid reference

    private final Square[][] grid;

    /*
     * Creates all 64 squares.
     *
     * Position uses 1-based coordinates:
     * (1,1) ... (8,8)
     *
     * Array uses 0-based coordinates:
     * [0][0] ... [7][7]
     */
    private void createGrid() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {

                Position position =
                        new Position(i + 1, j + 1);

                this.grid[i][j] =
                        new Square(position);
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
                new Rook(
                        color,
                        new Position(row + 1, 1)
                )
        );

        this.grid[row][1].placePiece(
                new Knight(
                        color,
                        new Position(row + 1, 2)
                )
        );

        this.grid[row][2].placePiece(
                new Bishop(
                        color,
                        new Position(row + 1, 3)
                )
        );

        this.grid[row][3].placePiece(
                new Queen(
                        color,
                        new Position(row + 1, 4)
                )
        );

        this.grid[row][4].placePiece(
                new King(
                        color,
                        new Position(row + 1, 5)
                )
        );

        this.grid[row][5].placePiece(
                new Bishop(
                        color,
                        new Position(row + 1, 6)
                )
        );

        this.grid[row][6].placePiece(
                new Knight(
                        color,
                        new Position(row + 1, 7)
                )
        );

        this.grid[row][7].placePiece(
                new Rook(
                        color,
                        new Position(row + 1, 8)
                )
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
            throw new IllegalArgumentException(
                    "Position cannot be null"
            );
        }

        if (!isValidPosition(position)) {
            throw new IllegalArgumentException(
                    "Position must be between 1 and 8"
            );
        }

        return this.grid[
                position.getRow() - 1
                ][
                position.getColumn() - 1
                ];
    }

    private boolean isValidPosition(Position position) {

        if (position == null) {
            return false;
        }

        return position.getRow() >= 1
                && position.getRow() <= 8
                && position.getColumn() >= 1
                && position.getColumn() <= 8;
    }

    /*
     * Checks whether all intermediate squares
     * between source and destination are empty.
     *
     * Destination itself is NOT checked here.
     */
    private boolean isPathClear(Position from, Position to) {

        int fromRow = from.getRow();
        int fromCol = from.getColumn();

        int toRow = to.getRow();
        int toCol = to.getColumn();

        int rowStep = 0;
        int colStep = 0;

        if (toRow > fromRow) {
            rowStep = 1;
        } else if (toRow < fromRow) {
            rowStep = -1;
        }

        if (toCol > fromCol) {
            colStep = 1;
        } else if (toCol < fromCol) {
            colStep = -1;
        }

        int currentRow = fromRow + rowStep;
        int currentCol = fromCol + colStep;

        while (currentRow != toRow
                || currentCol != toCol) {

            Position currentPosition =
                    new Position(currentRow, currentCol);

            if (getSquare(currentPosition).isOccupied()) {
                return false;
            }

            currentRow += rowStep;
            currentCol += colStep;
        }

        return true;
    }

    public boolean isValidMove(Position from, Position to) {

        // 1. Validate positions
        if (!isValidPosition(from)
                || !isValidPosition(to)) {
            return false;
        }

        // 2. Same source and destination
        if (from.getRow() == to.getRow()
                && from.getColumn() == to.getColumn()) {
            return false;
        }

        // 3. Source square
        Square sourceSquare = getSquare(from);

        // 4. Source must contain a piece
        if (!sourceSquare.isOccupied()) {
            return false;
        }

        Piece piece = sourceSquare.getPiece();

        // 5. Ask the Piece about its movement geometry
        if (!piece.canMove(from, to)) {
            return false;
        }

        // 6. Check intermediate path for sliding pieces
        if (piece instanceof Rook
                || piece instanceof Bishop
                || piece instanceof Queen) {

            if (!isPathClear(from, to)) {
                return false;
            }
        }

        // 7. Destination square
        Square destinationSquare = getSquare(to);

        // 8. Empty destination → valid
        if (!destinationSquare.isOccupied()) {
            return true;
        }

        // 9. Destination contains a piece
        Piece destinationPiece =
                destinationSquare.getPiece();

        // 10. Same color → cannot move there
        if (destinationPiece.getColor()
                == piece.getColor()) {
            return false;
        }

        // 11. Opponent piece → capture is possible
        return true;
    }

    public boolean move(Position from, Position to) {

        if (!isValidMove(from, to)) {
            return false;
        }

        Square sourceSquare = getSquare(from);
        Square destinationSquare = getSquare(to);

        Piece sourcePiece = sourceSquare.getPiece();
        Piece destinationPiece =
                destinationSquare.getPiece();

        // Capture if destination is occupied
        if (destinationPiece != null) {
            destinationPiece.markCaptured();
        }

        // Remove piece from source
        sourceSquare.removePiece();

        // Update the piece's position
        sourcePiece.moveTo(to);

        // Place piece on destination
        destinationSquare.placePiece(sourcePiece);

        return true;
    }

    /*
     * Displays the current board.
     *
     * White pieces  -> uppercase
     * Black pieces  -> lowercase
     * Empty square  -> .
     */
    public void display() {

        System.out.println(this.toString());
    }

    @Override
    public String toString() {

        StringBuilder board = new StringBuilder();

        board.append("\n");

        for (int row = 8; row >= 1; --row) {

            board.append(row).append(" ");

            for (int col = 1; col <= 8; ++col) {

                Square square =
                        getSquare(new Position(row, col));

                if (!square.isOccupied()) {

                    board.append(". ");

                } else {

                    Piece piece =
                            square.getPiece();

                    board.append(
                            getPieceSymbol(piece)
                    ).append(" ");
                }
            }

            board.append("\n");
        }

        board.append("  ");
        board.append("1 2 3 4 5 6 7 8\n");

        return board.toString();
    }

    private char getPieceSymbol(Piece piece) {

        char symbol;

        switch (piece.getPieceType()) {

            case KING:
                symbol = 'K';
                break;

            case QUEEN:
                symbol = 'Q';
                break;

            case ROOK:
                symbol = 'R';
                break;

            case BISHOP:
                symbol = 'B';
                break;

            case KNIGHT:
                symbol = 'N';
                break;

            case PAWN:
                symbol = 'P';
                break;

            default:
                symbol = '?';
        }

        if (piece.getColor() == Color.BLACK) {
            symbol = Character.toLowerCase(symbol);
        }

        return symbol;
    }
}