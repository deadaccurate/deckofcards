package com.deadaccurate;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class tests the Ace class.
 */
public class AceTest {

    /**
     * Test that the Ace returns the appropriate value if it is low or high.
     */
    @Test
    public void testAceValue() {
        Card ace = new Ace(Suit.Clubs, true);
        assertEquals(ace.getValue(), 1);
        ace = new Ace(Suit.Hearts, false);
        assertEquals(ace.getValue(), 14);
    }

    /**
     * Test that the Ace class initializes the card's suit and face value correctly.
     */
    @Test
    public void testInit() {
        Card ace = new Ace(Suit.Diamonds, true);
        assertEquals(ace.getSuit(), Suit.Diamonds);
        assertEquals(ace.getFaceValue(), FaceValue.Ace);
        ace = new Ace(Suit.Spades, false);
        assertEquals(ace.getSuit(), Suit.Spades);
        assertEquals(ace.getFaceValue(), FaceValue.Ace);
    }

    /**
     * Test that the Ace's equals and hashcode methods are implemented correctly.
     */
    @Test
    public void testEqualHashCode() {
        Card ace = new Ace(Suit.Clubs, false);
        assertEquals(ace, ace);
        Card hrtFalse = new Ace(Suit.Hearts, false);
        assertNotEquals(ace, hrtFalse);
        Card clFalse = new Ace(Suit.Clubs, false);
        assertEquals(ace, clFalse);
        assertEquals(clFalse, ace);
        assertNotEquals(ace, null);
        Card cardAce = new Card(Suit.Clubs, FaceValue.Ace);
        assertNotEquals(ace, cardAce);
        Card clTrue = new Ace(Suit.Clubs, true);
        assertNotEquals(ace, clTrue);

        assertNotEquals(ace.hashCode(), clTrue.hashCode());
        assertEquals(ace.hashCode(), ace.hashCode());
        assertEquals(ace.hashCode(), new Ace(Suit.Clubs, false).hashCode());
        assertNotEquals(ace.hashCode(), cardAce);
    }
}
