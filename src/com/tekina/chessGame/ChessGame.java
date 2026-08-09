package com.tekina.chessGame;

import java.util.ArrayList;
import java.util.List;

public class ChessGame {

    // Generated:
    // gameId, board, moveHistory

    // Mandatory:
    // whitePlayer, blackPlayer

    // Optional:
    // None

    // Mutable:
    // currentTurn, currentGameStatus, moveHistory contents

    // Immutable:
    // gameId, board, whitePlayer, blackPlayer,
    // moveHistory reference

    private static int nextGameId = 1;

    private final int gameId;
    private final Board board;
    private final Player whitePlayer;
    private final Player blackPlayer;
    private final List<Move> moveHistory;

    private Player currentTurn;
    private GameStatus currentGameStatus;

    public ChessGame(Player whitePlayer, Player blackPlayer) {

        if (whitePlayer == null || blackPlayer == null) {
            throw new IllegalArgumentException(
                    "Players cannot be null"
            );
        }

        if (whitePlayer.getColor() != Color.WHITE) {
            throw new IllegalArgumentException(
                    "First player must be WHITE"
            );
        }

        if (blackPlayer.getColor() != Color.BLACK) {
            throw new IllegalArgumentException(
                    "Second player must be BLACK"
            );
        }

        if (whitePlayer == blackPlayer) {
            throw new IllegalArgumentException(
                    "White and Black players must be different"
            );
        }

        this.gameId = nextGameId++;
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;

        this.board = new Board();
        this.moveHistory = new ArrayList<Move>();

        this.currentTurn = whitePlayer;
        this.currentGameStatus = GameStatus.NOT_STARTED;
    }

    public void startGame() {

        if (this.currentGameStatus != GameStatus.NOT_STARTED) {
            return;
        }

        this.currentGameStatus = GameStatus.IN_PROGRESS;
        this.currentTurn = this.whitePlayer;
    }

    public int getGameId() {
        return this.gameId;
    }

    public Board getBoard() {
        return this.board;
    }

    public Player getWhitePlayer() {
        return this.whitePlayer;
    }

    public Player getBlackPlayer() {
        return this.blackPlayer;
    }

    public Player getCurrentTurn() {
        return this.currentTurn;
    }

    public GameStatus getCurrentGameStatus() {
        return this.currentGameStatus;
    }

    public List<Move> getMoveHistory() {
        return new ArrayList<Move>(this.moveHistory);
    }

    public boolean makeMove(
            Player player,
            Position from,
            Position to) {

        // Game must be running
        if (this.currentGameStatus != GameStatus.IN_PROGRESS) {
            return false;
        }

        // Player cannot be null
        if (player == null) {
            return false;
        }

        // Only players participating in this game
        if (player != this.whitePlayer
                && player != this.blackPlayer) {
            return false;
        }

        // Player must have the current turn
        if (player != this.currentTurn) {
            return false;
        }

        // Capture the state BEFORE Board changes it
        Piece movedPiece =
                this.board.getSquare(from).getPiece();

        Piece capturedPiece =
                this.board.getSquare(to).getPiece();

        // Board owns move validation + state transition
        boolean successful =
                this.board.move(from, to);

        if (!successful) {
            return false;
        }

        // Record successful move
        Move move = new Move(
                movedPiece,
                from,
                to,
                capturedPiece,
                null
        );

        addMove(move);

        // White -> Black
        // Black -> White
        changeTurn();

        return true;
    }

    private void addMove(Move move) {

        if (move == null) {
            return;
        }

        this.moveHistory.add(move);
    }

    private void changeTurn() {

        if (this.currentTurn == this.whitePlayer) {
            this.currentTurn = this.blackPlayer;
        } else {
            this.currentTurn = this.whitePlayer;
        }
    }

    public void endGame() {

        if (this.currentGameStatus == GameStatus.IN_PROGRESS) {
            this.currentGameStatus = GameStatus.ENDED;
        }
    }

    public void display() {

        System.out.println("Game ID: " + this.gameId);

        System.out.println(
                "White Player: " + this.whitePlayer.getName()
        );

        System.out.println(
                "Black Player: " + this.blackPlayer.getName()
        );

        System.out.println(
                "Game Status: " + this.currentGameStatus
        );

        if (this.currentTurn != null) {
            System.out.println(
                    "Current Turn: " +
                            this.currentTurn.getName() +
                            " (" +
                            this.currentTurn.getColor() +
                            ")"
            );
        }

        System.out.println(
                "Moves Played: " +
                        this.moveHistory.size()
        );

        this.board.display();
    }

    @Override
    public String toString() {

        return "ChessGame{" +
                "gameId=" + gameId +
                ", whitePlayer=" + whitePlayer +
                ", blackPlayer=" + blackPlayer +
                ", currentTurn=" + currentTurn +
                ", currentGameStatus=" + currentGameStatus +
                ", moveHistory=" + moveHistory +
                '}';
    }
}