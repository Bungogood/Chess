package com.bungogood.Tests;

import com.bungogood.chess.FEN;
import com.bungogood.chess.chess.Move;
import com.bungogood.chess.chess.Board;
import com.bungogood.solver.Solver;

public class SolverTest {
    public static void main(String[] args) {
        Solver solver = new Solver();
        Board board = FEN.start();
        Move move = solver.solve(board);
    }
}
