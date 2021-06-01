package com.bungogood.solver;

import com.bungogood.chess.chess.Board;
import com.bungogood.chess.chess.Move;

import java.util.HashMap;

public class Solver {
    public static final int INFINITY = Integer.MAX_VALUE;
    public static final int MAXDEPTH = 9;

    public final HashMap<Board, TTEntry> transposition;

    public Solver() {
        this.transposition = new HashMap<>();
    }

    public Move solve(Board board) {
        Move best = null;
        int max = -INFINITY;
        int score;

        for (Move move : board.generateMoves()) {
            board.move(move);
            score = -negamax(board, MAXDEPTH, max, INFINITY);
            board.undo(move);
            if (score > max) {
                best = move;
                max = score;
            }
        }
        return best;
    }

    public int negamax(Board board, int depth, int alpha, int beta) {
        int alphaOrig = alpha;

        if (transposition.containsKey(board)) {
            TTEntry ttEntry = transposition.get(board);
            if (ttEntry.depth >= depth) {
                switch (ttEntry.flag) {
                    case LOWERBOUND:
                        alpha = Math.max(alpha, ttEntry.value);
                        break;
                    case UPPERBOUND:
                        beta = Math.min(beta, ttEntry.value);
                        break;
                    case EXACT:
                        return ttEntry.value;
                }
                if (alpha >= beta) return ttEntry.value;
            }
        }

        if (depth == 0) {
            return board.score();
            // explore only captures
        } else if (board.gameover()) {
            return board.score();
        }

        int best = -INFINITY;
        int score;
        for (Move move : board.generateMoves()) {
            board.move(move);
            score = -negamax(board, depth-1, -beta, -alpha);
            board.undo(move);
            if(score > best) {
                best = score;
                if (best > alpha) {
                    if (best >= beta) break;
                    else alpha = best;
                }
            }
        }

        TTEntry.Flag flag;
        if (best <= alphaOrig) {
            flag = TTEntry.Flag.UPPERBOUND;
        } else if (best >= beta) {
            flag = TTEntry.Flag.LOWERBOUND;
        } else {
            flag = TTEntry.Flag.EXACT;
        }

        transposition.put(board, new TTEntry(flag, depth, best));

        return best;
    }

    /*
    public int captures(Board board, int depth, int alpha, int beta) {
        int alphaOrig = alpha;

        if (transposition.containsKey(board)) {
            TTEntry ttEntry = transposition.get(board);
            if (ttEntry.depth >= depth) {
                switch (ttEntry.flag) {
                    case LOWERBOUND:
                        alpha = Math.max(alpha, ttEntry.value);
                        break;
                    case UPPERBOUND:
                        beta = Math.min(beta, ttEntry.value);
                        break;
                    case EXACT:
                        return ttEntry.value;
                }
                if (alpha >= beta) return ttEntry.value;
            }
        }

        // generate moves

        if (len captures == 0) {
            return board.score();
        } else if (board.gameover()) {
            board.score();
        }

        int best = -INFINITY;
        int score;
        for (Move move : board.generateCaptures()) {
            board.move(move);
            score = -negamax(board, depth-1, -beta, -alpha);
            board.undo(move);
            if(score > best) {
                best = score;
                if (best > alpha) {
                    if (best >= beta) break;
                    else alpha = best;
                }
            }
        }

        TTEntry.Flag flag;
        if (best <= alphaOrig) {
            flag = TTEntry.Flag.UPPERBOUND;
        } else if (best >= beta) {
            flag = TTEntry.Flag.LOWERBOUND;
        } else {
            flag = TTEntry.Flag.EXACT;
        }

        transposition.put(board, new TTEntry(flag, depth, best));

        return best;
    }
     */
}
