package com.deadaccurate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

public class DeckBuilderTest {

    private HashSet<Card> verDeck;
    private static final Suit[] SUITS = {
            Suit.Hearts,
            Suit.Spades,
            Suit.Clubs,
            Suit.Diamonds
    };
    private static final FaceValue[] FACE_VALUES = {
            FaceValue.Ace,
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

    @Before
    public void setUp() {
        verDeck = new HashSet<>();
        for (Suit suit : SUITS) {
            for (FaceValue faceValue : FACE_VALUES) {
                verDeck.add(new Card(suit, faceValue));
            }
        }
    }

    @Test
    public void testAddSuitsFaceValues() {
        CardBuilder cardBuilder = new
        DeckBuilder builder = new DeckBuilder()
        Deck<Card> deck = builder.addSuitsAndFaceValues();
        Assert.assertEquals(deck.size(), 0);
    }
}
