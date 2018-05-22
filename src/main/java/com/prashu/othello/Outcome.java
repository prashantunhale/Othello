package com.prashu.othello;

/**
 * There could be three possibilities of when player places the disc:
 *  He places the disc on a spot where other disc is already placed - SPACE_ALREADY_TAKEN
 *  He places the disc on a spot which is not legal according to Othello rules - NOT_A_LEGAL_MOVE
 *  He places the disc on a spot which is a legal according to Othello rules - LEGAL_MOVE
 */
public enum Outcome {
    SPACE_ALREADY_TAKEN("Not A Valid Move - Spot Already Taken"),
    NOT_A_LEGAL_MOVE("Not A Legal Move"),
    LEGAL_MOVE("Legal Move");

    private final String result;

    Outcome(String result){
        this.result = result;
    }

    public String getResult(){
        return result;
    }
}
