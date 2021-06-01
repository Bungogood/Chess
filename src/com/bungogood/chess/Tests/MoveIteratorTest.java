package com.bungogood.Tests;

import com.bungogood.chess.chess.Move;
import com.bungogood.chess.chess.MoveGenerator;

public class MoveIteratorTest {
    public static void main(String[] args) {
        MoveGenerator gen = new MoveGenerator(null, null, true);
        for (Move move : gen) {
            System.out.println(move.src);
        }
    }
}
