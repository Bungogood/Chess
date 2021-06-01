package com.bungogood.chess.chess;

import java.util.*;

public class MoveGenerator implements Iterable<Move> {

    private static final int[] dirs = {-8, 8, -1, 1, -7, 7, -9, 9};

    /*
    when generating moves
    look at captures first
    then
     */

    public final List<Piece> pieces;
    public final Board board;

    private final List<Move> moves;
    // private final List<Move> direct;
    // private final List<Move> sliding;
    private boolean isWhite;

    public MoveGenerator(Board board, List<Piece> pieces, boolean isWhite) {
        // figure out forwards
        this.board = board;
        this.pieces = pieces;
        this.isWhite = isWhite;
        this.moves = new ArrayList<Move>();
    }

    @Override
    public Iterator<Move> iterator() {
        return moves.iterator();
        //return new MoveIterator(this);
    }

    public Iterator<Move> generate(Piece piece) {
        return new PieceIterator(this, piece);
    }

    /*
    private List<Move> generate() {
        List<Move> moves = new ArrayList<>();
        for (Piece piece : pieces) {
            switch (piece.type) {
                case Pawn:
                    moves.addAll(pawn(piece));
                    break;
                case Rook:
                    moves.addAll(rook(piece));
                    rook(piece);
                    break;
                case Knight:
                    moves.addAll(knight(piece));
                    break;
                case Bishop:
                    moves.addAll(bishop(piece));
                    break;
                case Queen:
                    moves.addAll(queen(piece));
                    break;
                case King:
                    moves.addAll(king(piece));
                    break;
            }
        }
        return moves;
    }

/*
    private List<Move> _generate() {
        moves.clear();
        moves.addAll(direct);
        // add all lines;
        return moves;
    }

 */

    /*
    private List<Move> pawn(Piece piece) {
        moves.add(direct(forward));
        if (en passant)
            if (forward left) moves.add(new Move())
            if (forward right)
        if (forward left) direct(forward left);
        if (forward right) direct(forward left);
        if (in second row) direct(forward two);
    }

    private List<Move> knight(Piece piece) {
        List<Move> moves = new ArrayList<>();

        for each possible knight move
        check if move is valid
        then if valid add to list

        direct(moves, piece.index, piece.index+);
        direct(moves, piece.index, piece.index+dirs[i]);
        direct(moves, piece.index, piece.index+dirs[i]);
        direct(moves, piece.index, piece.index+dirs[i]);
    }

    private List<Move> king(Piece piece) {
        List<Move> moves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            direct(moves, piece, piece.index+dirs[i]);
        }
        return moves;
    }

    private List<Move> rook(Piece piece) {
        for (int i = 0; i < 4; i++) {
            moves.add(lines(piece.index, i));
        }
    }

    private List<Move> bishop(Piece piece) {
        for (int i = 4; i < 8; i++) {
            moves.add(lines(piece.index, i));
        }
    }

    private List<Move> _queen(Piece piece) {
        for (int i = 0; i < 8; i++) {
            moves.add(lines(piece.index, i));
        }
    }

    private List<Move> queen(Piece piece) {
        int[] limits = getLimits(piece);

        int up = limits[0];
        int down = limits[2];
        int left = limits[1];
        int right = limits[3];

        moves.add(Piece.index, upright, Math.min(up, right));
        moves.add(index, upleft,    Math.min(up, left));
        moves.add(index, downright, Math.min(down, right));
        moves.add(index, downleft,  Math.min(down, left));
        moves.add(index, up, up);
        moves.add(index, up, up);
        moves.add(index, up, up);
        moves.add(index, up, up);
    }

    private void line (int index, int dir, int number) {
        for (int i = 0; i < number; i++) {
            if (board.board[index + dir * i] != null) {
                enemy blocking
            }
            new Move(index, index + dir * i);
        }
    }

    private int[] getLimits(Piece piece) {
        int row = piece.index / 8;
        int col = piece.index % 8;
        return new int[] { row, col, 7-row, 7-col };
    }

    private void smart(Piece piece) {
        // check left

        num up = row;
        num down = 7-row;

        num left = col;
        num right = 7-col;

        // diagonal
        int num = Math.min(left, up);
        for (int i = 0; i < num; i++) {
            loc = i*dir + loc;
            if (piece block) {
                if (enemy) {
                    add move take;
                }
                break;
            } else {
                add move
            }
        }
    }

    /*
     * -9 |-8 |-7
     * -1 | i | 1
     *  7 | 8 | 9

    private void lines(int index, int dir) {
        int inc = dirs[dir];
        index += inc;
        while (isValid(index, inc) && board.board[index+inc] == null) {

            moves.add(index);
            index += inc;
            // somehow check it doesnt go over an edge effiecently
        }
    }

    private void direct(List<Move> moves, Piece piece, int dest) {
        Piece attacking = board.board[dest];
        if (attacking == null) {
            moves.add(new Move(piece.index, dest));
        } else if (attacking.isWhite != isWhite) {
            moves.add(new Move(piece.index, dest));
        }
    }

    public List<Move> getMoves() {
        return moves;
    }

    private boolean isValid(int index, int inc) {
        return isValidInc(index, inc) && isValidSquare(index+inc);
    }

    private boolean isValidInc(int index, int inc) {
        return index / 8 + inc / 8 == (index+inc) / 8;
    }

    private boolean isValidSquare(int index) {
        return 0 <= index && index < 64;
    }

    @Override
    public Iterator<Move> iterator() {
        return new MoveIterator();
    }

    @Override
    public void forEach(Consumer action) {
        /*
        go though each piece

    }

    /*
    after a move loop though all lines
    if line intersects move cancel all further lines


    if dest is between piece and
     */

    // the best way to do this is lazily
}
