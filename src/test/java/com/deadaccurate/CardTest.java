package com.deadaccurate;

import org.junit.Assert;
import org.junit.Test;

/**
 * CardTest contains tests for the Card class.
 */
public class CardTest {

    /**
     * Tests that the card's value is the same as the card's face value.
     */
    @Test
    public void testGetValue() {
        Assert.assertEquals(new Card(Suit.Hearts, FaceValue.Ace).getValue(), FaceValue.Ace.getValue());
        Assert.assertEquals(new Card(Suit.Diamonds, FaceValue.King).getValue(), FaceValue.King.getValue());
    }

    /**
     * Tests that the card's face value is the same as the enum passed to the constructor.
     */
    @Test
    public void testGetFaceValue() {
        Assert.assertEquals(new Card(Suit.Clubs, FaceValue.Two).getFaceValue(), FaceValue.Two);
        Assert.assertEquals(new Card(Suit.Diamonds, FaceValue.Seven).getFaceValue(), FaceValue.Seven);
    }

    /**
     * Tests that the card's suit is the same as the enum passed to the constructor.
     */
    @Test
    public void testGetSuit() {
        Assert.assertEquals(new Card(Suit.Spades, FaceValue.Three).getSuit(), Suit.Spades);
        Assert.assertEquals(new Card(Suit.Hearts, FaceValue.Six).getSuit(), Suit.Hearts);
    }

    /**
     * Tests that the equals method returns true if the cards are truly equal.
     */
    @Test
    public void testEquals() {
        Card spQueen = new Card(Suit.Spades, FaceValue.Queen);
        Card spQueen2 = new Card(Suit.Spades, FaceValue.Queen);
        // Reflexive
        Assert.assertEquals(spQueen, spQueen);
        // Symmetric
        Assert.assertEquals(spQueen, spQueen2);
        Assert.assertEquals(spQueen2, spQueen);
        // Transitive
        Card spQueen3 = new Card(Suit.Spades, FaceValue.Queen);
        Assert.assertEquals(spQueen, spQueen3);
        Assert.assertEquals(spQueen3, spQueen2);
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
        Assert.assertNotEquals(heartJack, clubEight);
        // Null
        Assert.assertNotEquals(heartJack, null);
        // Suits are the same
        Assert.assertNotEquals(heartJack, heartThree);
        // Two different classes
        Assert.assertNotEquals(clubEight, FaceValue.Jack);
        Assert.assertNotEquals(spNull, spFive);
    }

    /**
     * Tests that the hash code for two identical cards is the same and different for two different cards.
     */
    @Test
    public void testHashCode() {
        Card diamondSeven = new Card(Suit.Diamonds, FaceValue.Seven);
        Card diamondSeven2 = new Card(Suit.Diamonds, FaceValue.Seven);
        Assert.assertEquals(diamondSeven.hashCode(), diamondSeven2.hashCode());
        Card clubKing = new Card(Suit.Clubs, FaceValue.King);
        Assert.assertNotEquals(clubKing.hashCode(), diamondSeven.hashCode());
        Assert.assertEquals(new Card(null, null).hashCode(), new Card(null, null).hashCode());
    }
}
