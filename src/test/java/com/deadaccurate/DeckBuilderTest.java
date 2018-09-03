package com.deadaccurate;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class DeckBuilderTest {
    /**
     * Test that the deck builder creates the correct suits and face values for the deck.
     */
    @Test
    public void testAddSuitsFaceValues() {
        CardBuilder cardBuilder = new AceBuilder(true);
        // Default QueueNumberGenerator will leave the cards in the same order
        DeckBuilder builder = new DeckBuilder(cardBuilder, new QueueNumberGenerator());
        builder.addSuitsAndFaceValues(Collections.singletonList(Suit.Spades),
                Arrays.asList(FaceValue.Ace, FaceValue.Seven));
        Deck<Card> deck = builder.buildDeck();
        assertEquals(deck.size(), 2);
        // Won't change the order of the cards
        deck.shuffle();
        // Cards are dealt in LIFO order
        assertEquals(deck.dealOneCard(), new Card(Suit.Spades, FaceValue.Seven));
        assertEquals(deck.dealOneCard(), new Ace(Suit.Spades, true));
    }

    /**
     * Test that the deck builder supports multiple class to addSuitsAndFaceValues
     */
    @Test
    public void testAddMultiple() {
        CardBuilder cardBuilder = new AceBuilder(false);
        DeckBuilder builder = new DeckBuilder(cardBuilder, new QueueNumberGenerator());
        // 4 cards
        // Spades - King, Queen
        // Diamonds - King, Queen
        builder.addSuitsAndFaceValues(Arrays.asList(Suit.Spades, Suit.Diamonds),
                Arrays.asList(FaceValue.King, FaceValue.Queen));
        assertEquals(builder.buildDeck().size(), 4);
        // 1 card
        // Clubs - Eight
        builder.addSuitsAndFaceValues(Collections.singletonList(Suit.Clubs),
                Collections.singletonList(FaceValue.Eight));
        // 5 cards total
        assertEquals(builder.buildDeck().size(), 5);
    }
}
