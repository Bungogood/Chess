package com.bungogood.chess.chess;

public class History {

    public final Move move;
    public final Piece captured;
    public final int enPassant;
    public final int Castling;

    public History(Move move, Piece captured, int enPassant, int Castling) {
        this.move = move;
        this.captured = captured;
        this.enPassant = enPassant;
        this.Castling = Castling;
    }
}
