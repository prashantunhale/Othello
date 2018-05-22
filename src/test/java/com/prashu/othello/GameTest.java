package com.prashu.othello;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class GameTest {

    @Test
    public void testSwitchUser(){
        Assert.assertEquals(Game.switchUser(Disc.X), Disc.O);
        Assert.assertEquals(Game.switchUser(Disc.O), Disc.X);
    }

    @Test
    public void testMakeMove(){
        Assert.assertEquals(Game.makeMove(new Board(), Disc.X, new Position(0,0)), Outcome.NOT_A_LEGAL_MOVE);
        Assert.assertEquals(Game.makeMove(new Board(), Disc.X, new Position(3,3)), Outcome.SPACE_ALREADY_TAKEN);
        Assert.assertEquals(Game.makeMove(new Board(), Disc.X, new Position(3,2)), Outcome.LEGAL_MOVE);
    }

    @Test
    public void testPlayerXValidInput(){
        Scanner scanner = new Scanner("4C");
        Assert.assertEquals(Game.getPlayerInput(scanner, Disc.X), new Position(3, 2));
    }

    @Test
    public void testPlayerXInvalidThenValidInput(){
        Scanner scanner = new Scanner("9P\n4C");
        Assert.assertEquals(Game.getPlayerInput(scanner, Disc.X), new Position(3, 2));
    }

    /**
     * Sequence source - https://en.wikipedia.org/wiki/Reversi
     * The sequence mentioned below causes no more possible moves for any of the player. In that case the game should exit. Player O wins 45 to 13
     */
    @Test
    public void testPlayerOWinsScenario(){
        String sequence = "F5D6C5F6C4F4E6D7E7C6F7D8C8E8G5B8E3F8B6B5A6A4A5A7C7B4G6H6H7B3D3C3C2C1H5D2E2F1B1D1B2A3E1H4H3G4G3F3G1F2B7H2H1G7";

        String playerInputs = splitIntoPlayerInput(sequence);
        Scanner scanner = new Scanner(playerInputs);
        Board board = new Board();
        String result = Game.play(scanner, board);
        Assert.assertEquals(result, "\nPlayerX : 13,\tPlayerO : 45,\tPlayerO won!");
        String boardCheck = "\n" +
                "\ta\tb\tc\td\te\tf\tg\th\n" +
                "1\t-\tX\tX\tX\tX\tX\tX\tX\t1\n" +
                "2\t-\tO\tO\tO\tO\tO\t-\tX\t2\n" +
                "3\tO\tO\tO\tO\tO\tO\tO\tX\t3\n" +
                "4\tO\tO\tO\tO\tO\tO\tO\tX\t4\n" +
                "5\tO\tO\tO\tO\tO\tO\tO\tX\t5\n" +
                "6\tO\tO\tO\tO\tO\tO\tO\tX\t6\n" +
                "7\tO\tO\tO\tO\tO\tO\tO\tX\t7\n" +
                "8\t-\tO\tO\tO\tO\tO\t-\t-\t8\n" +
                " \ta\tb\tc\td\te\tf\tg\th\n" +
                "\n" +
                "PlayerX : 13,\tPlayerO : 45,\tEmpty Spots : 6";
        Assert.assertEquals(board.display(), boardCheck);
    }

    /**
     * Sequence source - https://en.wikipedia.org/wiki/Reversi
     * The stuckSequence mentioned below causes no more possible moves for any of the player. In that case the game should exit. It becomes a tie (30-30)
     */
    @Test
    public void testGameTieScenario(){
        String stuckSequence = "E6F4C3C4D3D6C5C6D7B5B6F7A6A5B4A7F3C8E8C7F6E7G8G6F8F5G4E3D2H3G5G3H4H5H7D8B8A4B3D1C1B1C2E1E2A3B7F2F1G1B2A2G2H6H2G7";

        String playerInputs = splitIntoPlayerInput(stuckSequence);
        Scanner scanner = new Scanner(playerInputs);
        Board board = new Board();
        String result = Game.play(scanner, board);
        Assert.assertEquals(result, "\nPlayerX : 30,\tPlayerO : 30,\tMatch Tie");
        String boardCheck = "\n" +
                "\ta\tb\tc\td\te\tf\tg\th\n" +
                "1\t-\tO\tO\tO\tO\tO\tO\t-\t1\n" +
                "2\tO\tO\tO\tO\tO\tO\tX\tX\t2\n" +
                "3\tO\tX\tO\tX\tO\tX\tX\tX\t3\n" +
                "4\tO\tX\tX\tO\tX\tO\tX\tX\t4\n" +
                "5\tO\tX\tO\tX\tO\tX\tO\tX\t5\n" +
                "6\tO\tX\tX\tX\tX\tO\tO\tX\t6\n" +
                "7\tO\tX\tX\tO\tO\tO\tO\tX\t7\n" +
                "8\t-\tX\tX\tX\tX\tX\tX\t-\t8\n" +
                " \ta\tb\tc\td\te\tf\tg\th\n" +
                "\n" +
                "PlayerX : 30,\tPlayerO : 30,\tEmpty Spots : 4";
        Assert.assertEquals(board.display(), boardCheck);

    }

    private String splitIntoPlayerInput(String moves){
        StringBuilder userInputs = new StringBuilder();
        for(int i = 0; i < moves.length(); ){
            userInputs.append(moves.substring(i, i+2) + "\n");
            i = i + 2;
        }
        return userInputs.toString();
    }

}
