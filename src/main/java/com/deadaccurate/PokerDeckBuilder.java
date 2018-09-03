package com.deadaccurate;

import java.util.Arrays;

/**
 * Creates a standard deck of 52 poker style playing cards with aces high (higher than King).
 */
public class PokerDeckBuilder {
    /**
     * Builds a deck of 52 poker style playing cards, suits: Spades, Diamonds, Clubs, Hearts.
     * Cards Ace, 2-10, Jack, Queen, and King.
     * @return a deck of cards object holding 52 cards. It is not yet shuffled.
     */
    public static Deck<Card> buildStandardDeck() {
        CardBuilder cardBuilder = new AceBuilder(false);
        DeckBuilder deckBuilder = new DeckBuilder(cardBuilder, new RandomGenerator());
        deckBuilder.addSuitsAndFaceValues(Arrays.asList(Suit.Spades, Suit.Diamonds, Suit.Clubs, Suit.Hearts),
                Arrays.asList(FaceValue.Ace,
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
                        FaceValue.King));
        return deckBuilder.buildDeck();
    }
}
