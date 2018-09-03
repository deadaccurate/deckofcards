package com.deadaccurate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * FaceValueTest contains tests for the FaceValue enum class.
 */
public class FaceValueTest {

    /**
     * Test that all the FaceValue names correspond to the correct string.
     */
    @Test
    public void testGetName() {
        assertEquals(FaceValue.Ace.getName(), "Ace");
        assertEquals(FaceValue.Two.getName(), "Two");
        assertEquals(FaceValue.Three.getName(), "Three");
        assertEquals(FaceValue.Four.getName(), "Four");
        assertEquals(FaceValue.Five.getName(), "Five");
        assertEquals(FaceValue.Six.getName(), "Six");
        assertEquals(FaceValue.Seven.getName(), "Seven");
        assertEquals(FaceValue.Eight.getName(), "Eight");
        assertEquals(FaceValue.Nine.getName(), "Nine");
        assertEquals(FaceValue.Ten.getName(), "Ten");
        assertEquals(FaceValue.Jack.getName(), "Jack");
        assertEquals(FaceValue.Queen.getName(), "Queen");
        assertEquals(FaceValue.King.getName(), "King");
    }

    /**
     * Test that all the FaceValue numeric values equal the correct value.
     */
    @Test
    public void testGetValue() {
        assertEquals(FaceValue.Ace.getValue(), 1);
        assertEquals(FaceValue.Two.getValue(), 2);
        assertEquals(FaceValue.Three.getValue(), 3);
        assertEquals(FaceValue.Four.getValue(), 4);
        assertEquals(FaceValue.Five.getValue(), 5);
        assertEquals(FaceValue.Six.getValue(), 6);
        assertEquals(FaceValue.Seven.getValue(), 7);
        assertEquals(FaceValue.Eight.getValue(), 8);
        assertEquals(FaceValue.Nine.getValue(), 9);
        assertEquals(FaceValue.Ten.getValue(), 10);
        assertEquals(FaceValue.Jack.getValue(), 11);
        assertEquals(FaceValue.Queen.getValue(), 12);
        assertEquals(FaceValue.King.getValue(), 13);
    }
}
