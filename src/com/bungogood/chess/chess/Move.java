package com.bungogood.chess.chess;

public class Move {

    public enum Flag { Castling, PawnTwoForward, EnPassantCapture, Promote }

    public final Flag flag;
    public final Piece.Type promote;

    // public final boolean capture;
    // public final Piece capture;

    public final int src;
    public final int dest;

    // Castling
    // Check, Checkmate, Draw

    public Move(int src, int dest) {
        this.src  = src;
        this.dest = dest;
        this.flag = null; // number for piece
        this.promote = null; // number for piece
    }

    public Move(int src, int dest, Flag flag, Piece.Type promote) {
        this.src  = src;
        this.dest = dest;
        this.flag = flag; // number for piece
        this.promote = promote; // number for piece
    }
}
