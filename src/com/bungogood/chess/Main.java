package com.bungogood.chess;

import com.bungogood.chess.chess.Board;
import com.bungogood.chess.chess.Move;

public class Main {

    public static void main(String[] args) {
        Board board = FEN.start();
        board.makeMove(new Move(Board.squareToIndex("e2"), Board.squareToIndex("e4")));
        String fen = FEN.toFen(board);

        checkFen("rnbqkbnr/8/8/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R b - - 1 2");

        Controller controller = new Controller();
        // View view = new View();

    }

    public static void checkFen(String def, String check) {
        System.out.println("defau fen: " + def);
        System.out.println("board fen: " + check);
        System.out.println(def.equals(check));
    }

    public static void checkFen(String str) {
        Board board = FEN.fromFen(str);
        String fen = FEN.toFen(board);
        checkFen(str, fen);
    }
}
