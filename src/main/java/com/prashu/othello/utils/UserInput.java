package com.prashu.othello.utils;

import com.prashu.othello.Position;

public class UserInput {

    /**
     * Converts inputs to Disc position
     * for example:
     * 1C or C1 or 1c or c1 : (0,2)
     * 8E or E8 or 8e or e8 : (7,4)
     */
    public static Position convertInputToPosition(String input){
        if(Character.isDigit(input.charAt(0))){
            int horizontalIndex = Character.getNumericValue(input.charAt(0)) - 1;
            int verticalIndex = mapCharacterToIndex(input.charAt(1));
            return new Position(horizontalIndex, verticalIndex);
        }else{
            int horizontalIndex = Character.getNumericValue(input.charAt(1)) - 1;
            int verticalIndex = mapCharacterToIndex(input.charAt(0));
            return new Position(horizontalIndex, verticalIndex);
        }
    }

    /**
     * Maps a/A to 0 ... h/H to 7
     */
    public static int mapCharacterToIndex(char c) {
        return (int) c >= 97 ? (int) c - 97 : (int) c - 65;
    }

    /**
     * Input examples: 1C, B2, d5, 8H
     */
    public static boolean validateInput(String input){
        return input.matches("[\\[1-8][a-hA-H]") || input.matches("[\\[a-hA-H][1-8]");
    }
}
