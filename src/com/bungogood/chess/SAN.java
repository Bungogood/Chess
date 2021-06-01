package com.bungogood.chess;

// Standard algebraic notation
// https://en.wikipedia.org/wiki/Algebraic_notation_(chess)

import com.bungogood.chess.chess.Board;
import com.bungogood.chess.chess.Move;

public class SAN {

    public static Move fromSan(Board board, String san) {

        /*

         */

        // after destination

        // O-O king side O-O-O queen side

        /*
        if castling
        else move
            if (multi piece) type
            if (!unambiguous) src
            if capture x
            dest
            if promtion =
                get piece type

        if check +
        elif checkmate ++
        elif draw =
         */
        Move move = new Move(0, 0);
        return null;
    }

    public static String toSan(Board board, Move move) {
        StringBuilder san = new StringBuilder();
        /*

        if (move.flag == Move.Flag.Castling) {
            boolean kingside = false;
            san.append(kingside ? "O-O" : "O-O-O");
        } else {
            san.append(Piece.getChar(board.board[move.src]));
            san.append(Board.indexToSquare(move.src));
            if (board.board[])
            if (multi piece) type
            if (!unambiguous) src
            if capture x
            dest
            if promtion =
                    get piece type
        }


        // Piece p = board.board[move.src];
        // san.append(pieceChar[p.id]);
        san.append(indexToSquare(move.src));
        san.append(indexToSquare(move.src));
        if (move.capture) san.append('x');

        san.append(Board.indexToSquare(move.dest));
        if (check) {
            san.append(mate ? "++" : "+");
        } else if (draw) {
            san.append("=");
        }


         */
        return san.toString();
    }
}
