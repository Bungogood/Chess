package com.bungogood.chess.chess;

import java.util.*;

/*
needs 2 different types of move function

one for real moves
    create a history entry

one for simulated moves
    just does bare minimum
 */

public class Board {

    private final Stack<History> history;
    private final MoveGenerator generator;
    private final ArrayList<Piece> whitePieces;
    private final ArrayList<Piece> blackPieces;
    private final Zobrist zobrist;

    public final Piece[] board;

    public boolean isWhite;
    public int castling; // KQkq
    public int enPassant;
    public int halfMove;
    public int fullMove;

    // history needs to store captured move type
    // en passant
    // castling rights

    public Board(Piece[] board, boolean isWhite, int castling, int enPassant, int halfMove, int fullMove) {
        this.board = board;
        this.isWhite = isWhite;
        this.castling = castling;
        this.enPassant = enPassant;
        this.halfMove = halfMove;
        this.fullMove = fullMove;

        this.history = new Stack<History>();
        this.whitePieces = new ArrayList<>();
        this.blackPieces = new ArrayList<>();
        this.generator = new MoveGenerator(this, whitePieces, true);
        this.zobrist = new Zobrist();
    }

    public void move(Move move) {
        movePiece(move.src, move.dest);
        isWhite = !isWhite;
    }

    public void undo(Move move) {
        movePiece(move.dest, move.src);
        isWhite = !isWhite;
    }

    private void movePiece(int src, int dest) {
        Piece piece = board[src];
        piece.index = dest;

        zobrist.xor(piece.type, src);
        zobrist.xor(piece.type, dest);

        board[dest] = piece;
        board[src] = null;
    }

    // to be improved and add move generation
    private void capturePiece(int src) {
        Piece piece = board[src];

        zobrist.xor(piece.type, src);

        board[src] = null;
    }

    // cleaver move generation
    // store blocking squares
    // store end squares
    // only generate moves after new move not every time

    // store the move history somehow
   /*
    public void makeMove(int src, int dest) {
        movePiece(src, dest);
        isWhite = !isWhite;
    }

    public void makeMove(Move move) {
        movePiece(move.src, move.dest);
        isWhite = !isWhite;
    }



    public void undoMove(History previous) {

    }

    public void undo() {
        undoMove(history.pop());
    }



    public void _move(Move move) {
        int oldCastling = castling;
        int oldEnPassant = enPassant;
        Piece captured = board[move.dest];

        enPassant = -1;

        // if (captured != null) {
        //
        // }

        if (move.flag == Move.Flag.PawnTwoForward) {
            enPassant = isWhite ? move.src + 8 : move.src - 8;
        } else if (move.flag == Move.Flag.Castling) {
            boolean kingSide = move.src % 8 == 6;
            int rookSrc = (kingSide) ? move.src + 1 : move.src - 2;
            int rookDst = (kingSide) ? move.src + 3 : move.src - 4;
            board[rookDst] = board[rookSrc];
            board[rookSrc] = null;
            // remove castling options now
        } else if (move.flag == Move.Flag.Promote) {
            board[move.dest].changeType(move.promote);
        } else if (move.flag == Move.Flag.EnPassantCapture) {
            captured = board[oldEnPassant];
            board[oldEnPassant] = null;
        }

        board[move.dest] = board[move.src];
        board[move.src] = null;

        history.push(new History(move, captured, oldEnPassant, oldCastling));
    }
    */

    public MoveGenerator generateMoves() {
        return generator;
    }

    public boolean gameover() {
        return false;
    }

    public int score() {
        return 0;
    }

    public static String indexToSquare(int index) {
        return Character.toString('a' + index % 8) + (index / 8 + 1);
    }

    public static int squareToIndex(String square) {
        char[] chars = square.toCharArray();
        return (chars[1] - '1') * 8 + chars[0] - 'a';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Board)) return false;
        Board board = (Board) obj;
        return zobrist.getHash() == board.zobrist.getHash();
    }

    @Override
    public int hashCode() {
        return zobrist.getHash();
    }
}
