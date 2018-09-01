package com.deadaccurate;

import org.junit.Assert;
import org.junit.Test;

/**
 * FaceValueTest contains tests for the FaceValue enum class.
 */
public class FaceValueTest {

    /**
     * Test that all the FaceValue names correspond to the correct string.
     */
    @Test
    public void testGetName() {
        Assert.assertEquals(FaceValue.Ace.getName(), "Ace");
        Assert.assertEquals(FaceValue.Two.getName(), "Two");
        Assert.assertEquals(FaceValue.Three.getName(), "Three");
        Assert.assertEquals(FaceValue.Four.getName(), "Four");
        Assert.assertEquals(FaceValue.Five.getName(), "Five");
        Assert.assertEquals(FaceValue.Six.getName(), "Six");
        Assert.assertEquals(FaceValue.Seven.getName(), "Seven");
        Assert.assertEquals(FaceValue.Eight.getName(), "Eight");
        Assert.assertEquals(FaceValue.Nine.getName(), "Nine");
        Assert.assertEquals(FaceValue.Ten.getName(), "Ten");
        Assert.assertEquals(FaceValue.Jack.getName(), "Jack");
        Assert.assertEquals(FaceValue.Queen.getName(), "Queen");
        Assert.assertEquals(FaceValue.King.getName(), "King");
    }

    /**
     * Test that all the FaceValue numeric values equal the correct value.
     */
    @Test
    public void testGetValue() {
        Assert.assertEquals(FaceValue.Ace.getValue(), 1);
        Assert.assertEquals(FaceValue.Two.getValue(), 2);
        Assert.assertEquals(FaceValue.Three.getValue(), 3);
        Assert.assertEquals(FaceValue.Four.getValue(), 4);
        Assert.assertEquals(FaceValue.Five.getValue(), 5);
        Assert.assertEquals(FaceValue.Six.getValue(), 6);
        Assert.assertEquals(FaceValue.Seven.getValue(), 7);
        Assert.assertEquals(FaceValue.Eight.getValue(), 8);
        Assert.assertEquals(FaceValue.Nine.getValue(), 9);
        Assert.assertEquals(FaceValue.Ten.getValue(), 10);
        Assert.assertEquals(FaceValue.Jack.getValue(), 11);
        Assert.assertEquals(FaceValue.Queen.getValue(), 12);
        Assert.assertEquals(FaceValue.King.getValue(), 13);
    }
}
