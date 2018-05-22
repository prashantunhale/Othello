package com.prashu.othello;

import org.junit.Assert;
import org.junit.Test;

public class BoardTest {

    @Test
    public void testBoardInitialization(){
        Board board = new Board();
        Assert.assertEquals("In default game setup O is placed at 3,3", board.getSpotValue(3, 3), Disc.O);
        Assert.assertEquals("In default game setup O is placed at 4,4", board.getSpotValue(4, 4), Disc.O);
        Assert.assertEquals("In default game setup X is placed at 3,4", board.getSpotValue(3, 4), Disc.X);
        Assert.assertEquals("In default game setup X is placed at 4,3", board.getSpotValue(4, 3), Disc.X);
        Assert.assertEquals("In default game setup - is placed at 0,0", board.getSpotValue(0, 0), Disc.E);
        Assert.assertEquals("In default game setup - is placed at 7,7", board.getSpotValue(7, 7), Disc.E);
        Assert.assertEquals("In default game setup initial score of player O is 2", board.playerOScore(),2);
        Assert.assertEquals("In default game setup initial score of player X is 2", board.playerXScore(),2);
        Assert.assertEquals("In default game setup initially there are 60 empty spots", board.emptySpots(),60);
        Assert.assertEquals(board.displayScores(),"\nPlayerX : 2,\tPlayerO : 2,\tEmpty Spots : 60");
        Assert.assertFalse(board.isGameFinished());
        Assert.assertFalse(board.allSpotsCovered());
        Assert.assertEquals(board.displayWinner(),"\nPlayerX : 2,\tPlayerO : 2,\tMatch Tie");
        Assert.assertEquals(board.getPosition(3,3), new Position(3,3));
    }

    @Test
    public void testBoardDisplay(){
        Board board = new Board();
        String initialDisplay = "\n" +
                "\ta\tb\tc\td\te\tf\tg\th\n" +
                "1\t-\t-\t-\t-\t-\t-\t-\t-\t1\n" +
                "2\t-\t-\t-\t-\t-\t-\t-\t-\t2\n" +
                "3\t-\t-\t-\t-\t-\t-\t-\t-\t3\n" +
                "4\t-\t-\t-\tO\tX\t-\t-\t-\t4\n" +
                "5\t-\t-\t-\tX\tO\t-\t-\t-\t5\n" +
                "6\t-\t-\t-\t-\t-\t-\t-\t-\t6\n" +
                "7\t-\t-\t-\t-\t-\t-\t-\t-\t7\n" +
                "8\t-\t-\t-\t-\t-\t-\t-\t-\t8\n" +
                " \ta\tb\tc\td\te\tf\tg\th\n" +
                "\n" +
                "PlayerX : 2,\tPlayerO : 2,\tEmpty Spots : 60";
        Assert.assertEquals(board.display(),initialDisplay);
    }

    @Test
    public void testFirstMove(){
        Board board = new Board();
        Assert.assertEquals("X moves first and it has 4 possible spots: 4C, 3D, 5F and 6E",board.getPossibleSpotsCount(Disc.X), 4);
        Assert.assertEquals("X moves first and 0,0 is not a legal move", board.placeDisc(new Position(0,0), Disc.X), Outcome.NOT_A_LEGAL_MOVE);
        Assert.assertEquals("X moves first and 3,3 is not a legal move since spot is already taken by O", board.placeDisc(new Position(3,3), Disc.X), Outcome.SPACE_ALREADY_TAKEN);
        Assert.assertEquals("X moves first and 4C (3,2) is a legal move", board.placeDisc(new Position(3,2), Disc.X), Outcome.LEGAL_MOVE);
        Assert.assertEquals("After first X legal 4C (3,2) move, (3,2) and (3,3) would be set to X", board.getSpotValue(3,2), Disc.X);
        Assert.assertEquals("After first X legal 4C (3,2) move, (3,2) and (3,3) would be set to X", board.getSpotValue(3,3), Disc.X);
        Assert.assertFalse(board.isGameFinished());
        Assert.assertEquals("After first X legal 4C (3,2) move, player O score would be 1", board.playerOScore(),1);
        Assert.assertEquals("After first X legal 4C (3,2) move, player X score would be 4", board.playerXScore(),4);
        Assert.assertEquals("After first X legal 4C (3,2) move, there still will be 59 empty spots", board.emptySpots(),59);
        Assert.assertEquals("After first X legal 4C (3,2) move, if game ends then X would be the winner",board.displayWinner(),"\nPlayerX : 4,\tPlayerO : 1,\tPlayerX won!");
    }

}
