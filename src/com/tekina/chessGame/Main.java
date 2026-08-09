package com.tekina.chessGame;

public class Main {

    public static void main(String[] args) {

        Player white = new Player("White Player", Color.WHITE);
        Player black = new Player("Black Player", Color.BLACK);

        ChessGame game = new ChessGame(white, black);

        game.startGame();

        System.out.println("===== INITIAL BOARD =====");
        game.display();


        // Move 1: White
        // Pawn E2 -> E4
        System.out.println("\n===== MOVE 1: WHITE E2 -> E4 =====");

        game.makeMove(
                white,
                new Position(2, 5),
                new Position(4, 5)
        );

        game.display();


        // Move 2: Black
        // Pawn E7 -> E5
        System.out.println("\n===== MOVE 2: BLACK E7 -> E5 =====");

        game.makeMove(
                black,
                new Position(7, 5),
                new Position(5, 5)
        );

        game.display();


        // Move 3: White
        // Knight G1 -> F3
        System.out.println("\n===== MOVE 3: WHITE G1 -> F3 =====");

        game.makeMove(
                white,
                new Position(1, 7),
                new Position(3, 6)
        );

        game.display();


        // Move 4: Black
        // Knight B8 -> C6
        System.out.println("\n===== MOVE 4: BLACK B8 -> C6 =====");

        game.makeMove(
                black,
                new Position(8, 2),
                new Position(6, 3)
        );

        game.display();


        // Move 5: White
        // Bishop F1 -> C4
        System.out.println("\n===== MOVE 5: WHITE F1 -> C4 =====");

        game.makeMove(
                white,
                new Position(1, 6),
                new Position(4, 3)
        );

        game.display();


        // Move 6: Black
        // Knight G8 -> F6
        System.out.println("\n===== MOVE 6: BLACK G8 -> F6 =====");

        game.makeMove(
                black,
                new Position(8, 7),
                new Position(6, 6)
        );

        game.display();


        // Move 7: White
        // Queen D1 -> H5
        System.out.println("\n===== MOVE 7: WHITE D1 -> H5 =====");

        game.makeMove(
                white,
                new Position(1, 4),
                new Position(5, 8)
        );

        game.display();


        // Move 8: Black
        // Pawn G7 -> G6
        System.out.println("\n===== MOVE 8: BLACK G7 -> G6 =====");

        game.makeMove(
                black,
                new Position(7, 7),
                new Position(6, 7)
        );

        game.display();


        // Move 9: White
        // Queen H5 -> E5
        System.out.println("\n===== MOVE 9: WHITE H5 -> E5 =====");

        game.makeMove(
                white,
                new Position(5, 8),
                new Position(5, 5)
        );

        game.display();


        // Move 10: Black
        // Pawn D7 -> D6
        System.out.println("\n===== MOVE 10: BLACK D7 -> D6 =====");

        game.makeMove(
                black,
                new Position(7, 4),
                new Position(6, 4)
        );

        game.display();


        System.out.println("\n===== MOVE HISTORY =====");

        for (Move move : game.getMoveHistory()) {
            System.out.println(move);
        }
    }
}