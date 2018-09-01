package com.deadaccurate;

import org.junit.Assert;
import org.junit.Test;

/**
 * SuitTest contains tests for the Suit class.
 */
public class SuitTest {

    /**
     * Tests that the Suits' colors equal the correct Color enum.
     */
    @Test
    public void testGetSuitColor() {
        Assert.assertEquals(Suit.Hearts.getColor(), Color.Red);
        Assert.assertEquals(Suit.Spades.getColor(), Color.Black);
        Assert.assertEquals(Suit.Clubs.getColor(), Color.Black);
        Assert.assertEquals(Suit.Diamonds.getColor(), Color.Red);
    }

    /**
     * Tests that the Suits' name equals the correct string name representation.
     */
    @Test
    public void testGetName() {
        Assert.assertEquals(Suit.Hearts.getName(), "Hearts");
        Assert.assertEquals(Suit.Spades.getName(), "Spades");
        Assert.assertEquals(Suit.Clubs.getName(), "Clubs");
        Assert.assertEquals(Suit.Diamonds.getName(), "Diamonds");
    }

    /**
     * Tests that the Suits' toString method returns the correct String representation of the enum.
     */
    @Test
    public void testToString() {
        String formatTemplate = "Suit: name: %1$s color: %2$s";
        Assert.assertEquals(Suit.Hearts.toString(),
                String.format(formatTemplate, "Hearts", Color.Red.getName()));
        Assert.assertEquals(Suit.Spades.toString(),
                String.format(formatTemplate, "Spades", Color.Black.getName()));
        Assert.assertEquals(Suit.Clubs.toString(),
                String.format(formatTemplate, "Clubs", Color.Black.getName()));
        Assert.assertEquals(Suit.Diamonds.toString(),
                String.format(formatTemplate, "Diamonds", Color.Red.getName()));
    }
}
