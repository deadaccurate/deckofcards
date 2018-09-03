package com.deadaccurate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * CardTest contains tests for the Card class.
 */
public class CardTest {

    /**
     * Tests that the card's value is the same as the card's face value.
     */
    @Test
    public void testGetValue() {
        assertEquals(new Card(Suit.Hearts, FaceValue.Ace).getValue(), FaceValue.Ace.getValue());
        assertEquals(new Card(Suit.Diamonds, FaceValue.King).getValue(), FaceValue.King.getValue());
    }

    /**
     * Tests that the card's face value is the same as the enum passed to the constructor.
     */
    @Test
    public void testGetFaceValue() {
        assertEquals(new Card(Suit.Clubs, FaceValue.Two).getFaceValue(), FaceValue.Two);
        assertEquals(new Card(Suit.Diamonds, FaceValue.Seven).getFaceValue(), FaceValue.Seven);
    }

    /**
     * Tests that the card's suit is the same as the enum passed to the constructor.
     */
    @Test
    public void testGetSuit() {
        assertEquals(new Card(Suit.Spades, FaceValue.Three).getSuit(), Suit.Spades);
        assertEquals(new Card(Suit.Hearts, FaceValue.Six).getSuit(), Suit.Hearts);
    }

    /**
     * Tests that the equals method returns true if the cards are truly equal.
     */
    @Test
    public void testEquals() {
        Card spQueen = new Card(Suit.Spades, FaceValue.Queen);
        Card spQueen2 = new Card(Suit.Spades, FaceValue.Queen);
        // Reflexive
        assertEquals(spQueen, spQueen);
        // Symmetric
        assertEquals(spQueen, spQueen2);
        assertEquals(spQueen2, spQueen);
        // Transitive
        Card spQueen3 = new Card(Suit.Spades, FaceValue.Queen);
        assertEquals(spQueen, spQueen3);
        assertEquals(spQueen3, spQueen2);
    }

    /**
     * Test that the equals method returns false if the cards truly are not equal.
     */
    @Test
    public void testNotEqual() {
        Card heartJack = new Card(Suit.Hearts, FaceValue.Jack);
        Card clubEight = new Card(Suit.Clubs, FaceValue.Eight);
        Card heartThree = new Card(Suit.Hearts, FaceValue.Three);
        Card spNull = new Card(Suit.Spades, null);
        Card spFive = new Card(Suit.Spades, FaceValue.Five);

        // Suit and FaceValue are different
        assertNotEquals(heartJack, clubEight);
        // Null
        assertNotEquals(heartJack, null);
        // Suits are the same
        assertNotEquals(heartJack, heartThree);
        // Two different classes
        assertNotEquals(clubEight, FaceValue.Jack);
        assertNotEquals(spNull, spFive);
    }

    /**
     * Tests that the hash code for two identical cards is the same and different for two different cards.
     */
    @Test
    public void testHashCode() {
        Card diamondSeven = new Card(Suit.Diamonds, FaceValue.Seven);
        Card diamondSeven2 = new Card(Suit.Diamonds, FaceValue.Seven);
        assertEquals(diamondSeven.hashCode(), diamondSeven2.hashCode());
        Card clubKing = new Card(Suit.Clubs, FaceValue.King);
        assertNotEquals(clubKing.hashCode(), diamondSeven.hashCode());
        assertEquals(new Card(null, null).hashCode(), new Card(null, null).hashCode());
    }
}
