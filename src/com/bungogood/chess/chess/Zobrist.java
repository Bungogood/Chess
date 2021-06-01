package com.bungogood.chess.chess;

import java.util.EnumMap;
import java.util.Random;

public class Zobrist {

    public final EnumMap<Piece.Type, Long[]> table;
    public int hash;

    public Zobrist() {
        Random rand = new Random();
        table = new EnumMap<>(Piece.Type.class);
        for (Piece.Type type : Piece.Type.values()) {
            table.put(type, new Long[64]);
            for (int index = 0; index < 64; index++) {
                table.get(type)[index] = rand.nextLong();
            }
        }
    }

    public void xor(Piece.Type type, int index) {
        hash ^= table.get(type)[index];
    }

    /*
    public long hash(Board board) {
        int h = 0;
        for (Piece p : board.blackPieces)
            h ^= table[p.index][p.id];
        for (Piece p : board.whitePieces)
            h ^= table[p.index][p.id];
        return h;
    }

    public void update(Board board, Move move) {
        // fails for enPassant
        // fails for castling
        Piece moving = board.board[move.src];
        Piece attacking = board.board[move.dest];
        hash ^= table[move.src][empty];
        hash ^= table[move.src][moving.id];
        hash ^= table[move.dest][moving.id];
        if (attacking != null) {
            hash ^= table[move.dest][attacking.id];
        } else {
            hash ^= table[move.dest][empty];
        }
        /*
        if (move.enPassant) {
            do the enPassant square
        }
        if (move.castling) {
            do the castling squares
        }
         */
        /* if using int to represent board
        hash ^= table[move.src][0];
        hash ^= table[move.src][board[move.src]];
        hash ^= table[move.dest][board[move.src]];
        hash ^= table[move.dest][board[move.dest]];

    }

         */
    public int getHash() {
        return hash;
    }
}
