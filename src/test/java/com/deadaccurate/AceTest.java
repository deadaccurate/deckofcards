package com.deadaccurate;

import org.junit.Assert;
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
        Assert.assertEquals(ace.getValue(), 1);
        ace = new Ace(Suit.Hearts, false);
        Assert.assertEquals(ace.getValue(), 11);
    }

    /**
     * Test that the Ace class initializes the card's suit and face value correctly.
     */
    @Test
    public void testInit() {
        Card ace = new Ace(Suit.Diamonds, true);
        Assert.assertEquals(ace.getSuit(), Suit.Diamonds);
        Assert.assertEquals(ace.getFaceValue(), FaceValue.Ace);
        ace = new Ace(Suit.Spades, false);
        Assert.assertEquals(ace.getSuit(), Suit.Spades);
        Assert.assertEquals(ace.getFaceValue(), FaceValue.Ace);
    }

    /**
     * Test that the Ace's equals and hashcode methods are implemented correctly.
     */
    @Test
    public void testEqualHashCode() {
        Card ace = new Ace(Suit.Clubs, false);
        Assert.assertEquals(ace, ace);
        Card hrtFalse = new Ace(Suit.Hearts, false);
        Assert.assertNotEquals(ace, hrtFalse);
        Card clFalse = new Ace(Suit.Clubs, false);
        Assert.assertEquals(ace, clFalse);
        Assert.assertEquals(clFalse, ace);
        Assert.assertNotEquals(ace, null);
        Card cardAce = new Card(Suit.Clubs, FaceValue.Ace);
        Assert.assertNotEquals(ace, cardAce);
        Card clTrue = new Ace(Suit.Clubs, true);
        Assert.assertNotEquals(ace, clTrue);

        Assert.assertNotEquals(ace.hashCode(), clTrue.hashCode());
        Assert.assertEquals(ace.hashCode(), ace.hashCode());
        Assert.assertEquals(ace.hashCode(), new Ace(Suit.Clubs, false).hashCode());
        Assert.assertNotEquals(ace.hashCode(), cardAce);
    }
}
