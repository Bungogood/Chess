package com.bungogood.chess.chess;

import java.util.EnumMap;
import java.util.HashMap;

public class Piece {
    public final static EnumMap<Type, Character> PieceChar = new EnumMap<>(Type.class) {
        {
            put(Type.Pawn,   'p');
            put(Type.Rook,   'r');
            put(Type.Knight, 'n');
            put(Type.Bishop, 'b');
            put(Type.Queen,  'q');
            put(Type.King,   'k');
        }
    };
    public final static HashMap<Character, Type> CharPiece = new HashMap<>() {
        {
            put('p', Type.Pawn);
            put('r', Type.Rook);
            put('n', Type.Knight);
            put('b', Type.Bishop);
            put('q', Type.Queen);
            put('k', Type.King);
        }
    };

    public enum Type { Pawn, Rook, Knight, Bishop, Queen, King }

    public final boolean isWhite;
    public int index;
    public Type type;

    public Piece (int index, boolean isWhite, Type type) {
        this.index = index;
        this.isWhite = isWhite;
        this.type = type;
    }

    public void changeType(Type type) {
        this.type = type;
    }

    public static Piece getPiece(int index, char chr) {
        return new Piece(index, Character.isUpperCase(chr), CharPiece.get(Character.toLowerCase(chr)));
    }

    public static char getChar(Piece piece) {
        char chr = PieceChar.get(piece.type);
        return piece.isWhite ? Character.toUpperCase(chr) : chr;
    }
}
