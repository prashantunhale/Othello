package com.prashu.othello;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PositionTest {

    @Test
    public void PositionEqualityTest(){
        Position x = new Position(3, 3);
        Position y = new Position(3, 3);
        Assert.assertEquals(x.getHorizontal(), y.getHorizontal());
        Assert.assertEquals(x.getVertical(), y.getVertical());
        Assert.assertTrue(x.equals(y));
        Position a = new Position( 4,4);
        Assert.assertFalse(x.equals(a));
    }

    @Test
    public void testSurroundingCardinalDirectionsOfCenterPoint(){
        Position p33 = new Position(3, 3);
        Assert.assertEquals("2,2 is NW of 3,3", p33.getNWPosition(), new Position(2, 2));
        Assert.assertEquals("2,3 is N of 3,3", p33.getNPosition(), new Position(2, 3));
        Assert.assertEquals("2,4 is NE of 3,3", p33.getNEPosition(), new Position(2, 4));
        Assert.assertEquals("3,2 is W of 3,3", p33.getWPosition(), new Position(3, 2));
        Assert.assertEquals("3,4 is E of 3,3", p33.getEPosition(), new Position(3, 4));
        Assert.assertEquals("4,2 is SW of 3,3", p33.getSWPosition(), new Position(4, 2));
        Assert.assertEquals("4,3 is S of 3,3", p33.getSPosition(), new Position(4, 3));
        Assert.assertEquals("4,4 is SE of 3,3", p33.getSEPosition(), new Position(4, 4));
    }

    @Test
    public void testSurroundingCardinalDirectionsOfCornerPoint(){
        Position p00 = new Position(0, 0);
        Assert.assertNull("There is no point NW of 0,0", p00.getNWPosition());
        Assert.assertNull("There is no point N of 0,0", p00.getNPosition());
        Assert.assertNull("There is no point NE of 0,0", p00.getNEPosition());
        Assert.assertNull("There is no point W of 0,0", p00.getWPosition());
        Assert.assertEquals("0,1 is E of 0,0", p00.getEPosition(), new Position(0, 1));
        Assert.assertNull("There is no point SW of 0,0", p00.getSWPosition());
        Assert.assertEquals("1,0 is S of 0,0", p00.getSPosition(), new Position(1, 0));
        Assert.assertEquals("1,1 is SE of 0,0", p00.getSEPosition(), new Position(1, 1));
    }

    @Test
    public void testAllCardinalDirectionPositionsOfCenterPoint(){
        Position p33 = new Position(3, 3);
        List<Position> pNW = new LinkedList<>(Arrays.asList(new Position(2,2), new Position(1,1), new Position(0,0)));
        List<Position> pN = new LinkedList<>(Arrays.asList(new Position(2,3), new Position(1,3), new Position(0,3)));
        List<Position> pNE = new LinkedList<>(Arrays.asList(new Position(2,4), new Position(1,5), new Position(0,6)));
        List<Position> pW = new LinkedList<>(Arrays.asList(new Position(3,2), new Position(3,1), new Position(3,0)));
        List<Position> pE = new LinkedList<>(Arrays.asList(new Position(3,4), new Position(3,5), new Position(3,6), new Position(3, 7)));
        List<Position> pSW = new LinkedList<>(Arrays.asList(new Position(4,2), new Position(5,1), new Position(6,0)));
        List<Position> pS = new LinkedList<>(Arrays.asList(new Position(4,3), new Position(5,3), new Position(6,3), new Position(7, 3)));
        List<Position> pSE = new LinkedList<>(Arrays.asList(new Position(4,4), new Position(5,5), new Position(6,6), new Position(7,7)));

        Assert.assertEquals("2,2-1,1-0,0 are NW of 3,3", p33.getAllNWPositions(), pNW);
        Assert.assertEquals("3,2-3,1-3,0 is N of 3,3", p33.getAllNPositions(), pN);
        Assert.assertEquals("2,4-1,5,0-6 is NE of 3,3", p33.getAllNEPositions(), pNE);
        Assert.assertEquals("3,2-3,1-3,0 is W of 3,3", p33.getAllWPositions(), pW);
        Assert.assertEquals("3,4-3,5-3,6-3,7 is E of 3,3", p33.getAllEPositions(), pE);
        Assert.assertEquals("4,2-5,1-6,0 is SW of 3,3", p33.getAllSWPositions(), pSW);
        Assert.assertEquals("4,3-5,3-6,3-7,3 is S of 3,3", p33.getAllSPositions(), pS);
        Assert.assertEquals("4,4-5,5-6,6-7,7 is SE of 3,3", p33.getAllSEPositions(), pSE);
    }

    @Test
    public void testAllCardinalDirectionPositionsOfCornerPoint(){
        Position p77 = new Position(7, 7);
        List<Position> pNW = new LinkedList<>(Arrays.asList(new Position(6,6), new Position(5,5), new Position(4,4),
                new Position(3,3), new Position(2, 2), new Position(1,1), new Position(0,0)));
        List<Position> pN = new LinkedList<>(Arrays.asList(new Position(6,7), new Position(5,7), new Position(4,7),
                new Position(3,7), new Position(2,7), new Position(1,7), new Position(0,7)));
        List<Position> pNE = Collections.emptyList();
        List<Position> pW = new LinkedList<>(Arrays.asList(new Position(7,6), new Position(7,5), new Position(7,4),
                new Position(7,3), new Position(7, 2), new Position(7,1), new Position(7,0)));
        List<Position> pE = Collections.emptyList();
        List<Position> pSW = Collections.emptyList();
        List<Position> pS = Collections.emptyList();
        List<Position> pSE = Collections.emptyList();

        Assert.assertEquals("6,6-5,5-4,4-3,3-2,2-1,1-0,0 are NW of 7,7", p77.getAllNWPositions(), pNW);
        Assert.assertEquals("6,7-5,7-4,7-3,7-2,7-1,7-0,7 are N of 7,7", p77.getAllNPositions(), pN);
        Assert.assertEquals("There is nothing NE of 7,7", p77.getAllNEPositions(), pNE);
        Assert.assertEquals("7,6-7,5-7,4-7,3-7,2-7,1-7,0 are W of 7,7", p77.getAllWPositions(), pW);
        Assert.assertEquals("There is nothing E of 7,7", p77.getAllEPositions(), pE);
        Assert.assertEquals("There is nothing SW of 7,7", p77.getAllSWPositions(), pSW);
        Assert.assertEquals("There is nothing S of 7,7", p77.getAllSPositions(), pS);
        Assert.assertEquals("There is nothing SE of 7,7", p77.getAllSEPositions(), pSE);
    }

}
