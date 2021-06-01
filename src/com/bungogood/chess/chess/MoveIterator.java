package com.bungogood.chess.chess;

import java.util.Iterator;

public class MoveIterator implements Iterator<Move> {

    MoveGenerator generator;
    Iterator<Piece> pieces;
    Iterator<Move> moves;

    public MoveIterator(MoveGenerator generator) {
        this.pieces = generator.pieces.iterator();
        this.moves = generator.generate(pieces.next());
    }

    @Override
    public boolean hasNext() {
        return pieces.hasNext() || moves.hasNext();
    }

    @Override
    public Move next() {
        if (!moves.hasNext()) {
            moves = generator.generate(pieces.next());
        }
        return moves.next();
    }
}
