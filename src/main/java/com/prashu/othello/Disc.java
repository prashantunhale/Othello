package com.prashu.othello;

/**
 * For any spot on the Othello board:
 *  Either disc is not placed : '-'
 *  Disc is placed on X side  : 'X'
 *  Disc is placed on O side  : 'O'
 */
public enum Disc{
    X ('X'),
    O ('O'),
    E ('-');

    private final Character side;

    Disc(Character side) {
        this.side = side;
    }

    Character getSide(){
        return side;
    }
}