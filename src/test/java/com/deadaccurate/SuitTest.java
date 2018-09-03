package com.deadaccurate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * SuitTest contains tests for the Suit class.
 */
public class SuitTest {

    /**
     * Tests that the Suits' colors equal the correct Color enum.
     */
    @Test
    public void testGetSuitColor() {
        assertEquals(Suit.Hearts.getColor(), Color.Red);
        assertEquals(Suit.Spades.getColor(), Color.Black);
        assertEquals(Suit.Clubs.getColor(), Color.Black);
        assertEquals(Suit.Diamonds.getColor(), Color.Red);
    }

    /**
     * Tests that the Suits' name equals the correct string name representation.
     */
    @Test
    public void testGetName() {
        assertEquals(Suit.Hearts.getName(), "Hearts");
        assertEquals(Suit.Spades.getName(), "Spades");
        assertEquals(Suit.Clubs.getName(), "Clubs");
        assertEquals(Suit.Diamonds.getName(), "Diamonds");
    }

    /**
     * Tests that the Suits' toString method returns the correct String representation of the enum.
     */
    @Test
    public void testToString() {
        String formatTemplate = "Suit: name: %1$s color: %2$s";
        assertEquals(Suit.Hearts.toString(),
                String.format(formatTemplate, "Hearts", Color.Red.getName()));
        assertEquals(Suit.Spades.toString(),
                String.format(formatTemplate, "Spades", Color.Black.getName()));
        assertEquals(Suit.Clubs.toString(),
                String.format(formatTemplate, "Clubs", Color.Black.getName()));
        assertEquals(Suit.Diamonds.toString(),
                String.format(formatTemplate, "Diamonds", Color.Red.getName()));
    }
}
