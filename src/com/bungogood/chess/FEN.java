package com.bungogood.chess;

// Forsyth–Edwards Notation
// https://en.wikipedia.org/wiki/Forsyth%E2%80%93Edwards_Notation

import com.bungogood.chess.chess.Board;
import com.bungogood.chess.chess.Piece;

public class FEN {

    public static final String startFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

    public static Board fromFen(String fen) {
        String[] raw = fen.split(" ");

        Piece[] board = new Piece[64];
        boolean isWhite = raw[1].equals("w");
        int castling = 0; // KQkq
        int enPassant = -1;
        int halfMove = Integer.parseInt(raw[4]);
        int fullMove = Integer.parseInt(raw[5]);

        String fenBoard = raw[0];
        String fenCastling = raw[2];
        String fenEnPassant = raw[3];

        if (!fenCastling.equals("-")) {
            for (char option : fenCastling.toCharArray()) {
                switch (option) {
                    case 'K':
                        castling |= 1;
                        break;
                    case 'Q':
                        castling |= 2;
                        break;
                    case 'k':
                        castling |= 4;
                        break;
                    case 'q':
                        castling |= 8;
                        break;
                }
            }
        }

        if (!fenEnPassant.equals("-")) {
            enPassant = Board.squareToIndex(fenEnPassant);
        }

        int row = 7;
        int col = 0;

        for (char symbol : fenBoard.toCharArray()) {
            if (symbol == '/') {
                col = 0;
                row--;
            } else {
                if (Character.isDigit(symbol)) {
                    col += Character.getNumericValue(symbol);
                } else {
                    board[row * 8 + col] = Piece.getPiece(row * 8 + col, symbol);
                    col++;
                }
            }
        }
        return new Board(board, isWhite, castling, enPassant, halfMove, fullMove);
    }

    public static String toFen(Board board) {
        StringBuilder fen = new StringBuilder();

        int count;
        Piece piece;

        for (int row = 7; row >= 0; row--) {
            count = 0;
            for (int col = 0; col < 8; col++) {
                piece = board.board[row * 8 + col];
                if (piece == null) {
                    count++;
                } else {
                    if (count != 0) fen.append(count);
                    count = 0;
                    fen.append(Piece.getChar(piece));
                }
            }
            if (count != 0) fen.append(count);
            if (row != 0) fen.append("/");
        }

        fen.append(" ");
        fen.append(board.isWhite ? "w" : "b");
        fen.append(" ");

        if (board.castling == 0) {
            fen.append("-");
        } else {
            if ((board.castling & 1) != 0) fen.append("K");
            if ((board.castling & 2) != 0) fen.append("Q");
            if ((board.castling & 4) != 0) fen.append("k");
            if ((board.castling & 8) != 0) fen.append("q");
        }

        fen.append(" ");

        if (board.enPassant == -1) {
            fen.append("-");
        } else {
            fen.append(Board.indexToSquare(board.enPassant));
        }

        fen.append(" ");
        fen.append(board.halfMove);

        fen.append(" ");
        fen.append(board.fullMove);

        return fen.toString();
    }

    public static Board start() {
        return FEN.fromFen(startFen);
    }
}
