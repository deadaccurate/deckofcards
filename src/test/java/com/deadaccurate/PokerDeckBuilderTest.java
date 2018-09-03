package com.deadaccurate;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * These test that a standard poker style 52 card deck is built by the PokerDeckBuilder.
 */
public class PokerDeckBuilderTest {

    private Deck<Card> pokerDeck;
    private HashSet<Card> verDeck;
    private static final Suit[] SUITS = {
            Suit.Hearts,
            Suit.Spades,
            Suit.Clubs,
            Suit.Diamonds
    };
    private static final FaceValue[] FACE_VALUES = {
            // Aces will be added separately
            FaceValue.Two,
            FaceValue.Three,
            FaceValue.Four,
            FaceValue.Five,
            FaceValue.Six,
            FaceValue.Seven,
            FaceValue.Eight,
            FaceValue.Nine,
            FaceValue.Ten,
            FaceValue.Jack,
            FaceValue.Queen,
            FaceValue.King
    };

    /**
     * Created a hash set that will be used to verify that all cards are were dealt.
     */
    @Before
    public void setUp() {
        pokerDeck = PokerDeckBuilder.buildStandardDeck();
        verDeck = new HashSet<>();
        for (Suit suit : SUITS) {
            verDeck.add(new Ace(suit, false));
            for (FaceValue faceValue : FACE_VALUES) {
                verDeck.add(new Card(suit, faceValue));
            }
        }
    }

    /**
     * Test that deck is 52 cards.
     */
    @Test
    public void testBuildStandardDeckSize() {
        assertEquals(pokerDeck.size(), verDeck.size());
    }

    /**
     * Test that deck contains all 52 cards.
     */
    @Test
    public void testBuildStandardDeck() {
        Card card;
        pokerDeck.shuffle();
        int size = pokerDeck.size();
        for (int i = 0; i < size; ++i) {
            card = pokerDeck.dealOneCard();
            assertNotNull(card);
            assertTrue(verDeck.remove(card));
        }
        assertEquals(pokerDeck.size(), 0);
        assertTrue(verDeck.isEmpty());
        assertNull(pokerDeck.dealOneCard());
    }
}
