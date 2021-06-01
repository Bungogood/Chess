package com.bungogood.solver;

public class TTEntry {
    public enum Flag { UPPERBOUND, LOWERBOUND, EXACT }

    public final Flag flag;
    public final int depth;
    public final int value;

    public TTEntry(Flag flag, int depth, int value) {
        this.flag = flag;
        this.depth = depth;
        this.value = value;
    }
}
