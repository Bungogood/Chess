package com.bungogood.chess.chess;

import java.util.Iterator;

public class PieceIterator implements Iterator<Move> {

    private MoveGenerator generator;

    public PieceIterator(MoveGenerator generator, Piece piece) {
        this.generator = generator;
    }

    @Override
    public boolean hasNext() {
        return false;
        // return moves.hasNext();
    }

    @Override
    public Move next() {
        return null;
        // return moves.next();
    }
}
