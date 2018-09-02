package com.deadaccurate;

import org.junit.Assert;
import org.junit.Test;

/**
 * AceBuilderTest contains tests for the AceLowBuilder to test building cards where the ace is valued as 1 (low).
 */
public class AceBuilderTest {
    /**
     * Test that the card returned has a value of one.
     */
    @Test
    public void testBuildCard() {
        AceBuilder builder = new AceBuilder(true);
        Card ace = builder.buildCard(Suit.Diamonds, FaceValue.Ace);
        Assert.assertEquals(ace.getValue(), 1);
        builder = new AceBuilder(false);
        ace = builder.buildCard(Suit.Spades, FaceValue.Ace);
        Assert.assertEquals(ace.getValue(), 11);
        Assert.assertEquals(builder.buildCard(Suit.Hearts, FaceValue.Seven), new Card(Suit.Hearts, FaceValue.Seven));
    }
}
