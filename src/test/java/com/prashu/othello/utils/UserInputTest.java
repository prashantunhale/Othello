package com.prashu.othello.utils;

import com.prashu.othello.Position;
import org.junit.Assert;
import org.junit.Test;

public class UserInputTest {

    @Test
    public void testConvertInputToPosition(){
        Position oneCPosition = UserInput.convertInputToPosition("1C");
        Assert.assertEquals("For 1C input, 0 should be horizontal index", oneCPosition.getHorizontal(), 0);
        Assert.assertEquals("For 1C input, 2 should be vertical index", oneCPosition.getVertical(), 2);
        Position onecPosition = UserInput.convertInputToPosition("1c");
        Assert.assertEquals("For 1c input, 0 should be horizontal index", onecPosition.getHorizontal(), 0);
        Assert.assertEquals("For 1c input, 2 should be vertical index", onecPosition.getVertical(), 2);
        Position C1Position = UserInput.convertInputToPosition("C1");
        Assert.assertEquals("For C1 input, 0 should be horizontal index", C1Position.getHorizontal(), 0);
        Assert.assertEquals("For C1 input, 2 should be vertical index", C1Position.getVertical(), 2);
        Position c1Position = UserInput.convertInputToPosition("c1");
        Assert.assertEquals("For C1 input, 0 should be horizontal index", c1Position.getHorizontal(), 0);
        Assert.assertEquals("For C1 input, 2 should be vertical index", c1Position.getVertical(), 2);
    }

    @Test
    public void testMapCharacterToIndex(){
        int [] oneToSeven = {0,1,2,3,4,5,6,7};
        int [] aToh = new int [8];
        aToh[0] = UserInput.mapCharacterToIndex('a');
        aToh[1] = UserInput.mapCharacterToIndex('b');
        aToh[2] = UserInput.mapCharacterToIndex('c');
        aToh[3] = UserInput.mapCharacterToIndex('d');
        aToh[4] = UserInput.mapCharacterToIndex('e');
        aToh[5] = UserInput.mapCharacterToIndex('f');
        aToh[6] = UserInput.mapCharacterToIndex('g');
        aToh[7] = UserInput.mapCharacterToIndex('h');
        Assert.assertArrayEquals(oneToSeven, aToh);

        int [] AToH = new int [8];
        AToH[0] = UserInput.mapCharacterToIndex('A');
        AToH[1] = UserInput.mapCharacterToIndex('B');
        AToH[2] = UserInput.mapCharacterToIndex('C');
        AToH[3] = UserInput.mapCharacterToIndex('D');
        AToH[4] = UserInput.mapCharacterToIndex('E');
        AToH[5] = UserInput.mapCharacterToIndex('F');
        AToH[6] = UserInput.mapCharacterToIndex('G');
        AToH[7] = UserInput.mapCharacterToIndex('H');
        Assert.assertArrayEquals(oneToSeven, AToH);
    }

    @Test
    public void testValidateInput(){
        Assert.assertTrue("2D is a valid input", UserInput.validateInput("2D"));
        Assert.assertTrue("2d is a valid input", UserInput.validateInput("2d"));
        Assert.assertTrue("D2 is a valid input", UserInput.validateInput("D2"));
        Assert.assertTrue("d2 is a valid input", UserInput.validateInput("d2"));
        Assert.assertFalse("22 is an invalid input", UserInput.validateInput("22"));
        Assert.assertFalse("DD is an invalid input", UserInput.validateInput("DD"));
        Assert.assertFalse("ee is an invalid input", UserInput.validateInput("ee"));
        Assert.assertFalse("2M is an invalid input", UserInput.validateInput("2M"));
        Assert.assertFalse("m2 is an invalid input", UserInput.validateInput("m2"));
    }

}
