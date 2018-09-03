package com.deadaccurate;

import java.util.ArrayList;
import java.util.List;

/**
 * DeckBuilder helps build a deck of cards. A caller can control the type of cards to build by passing in the card
 * builder object and also define the type of deck to build. The deck built will depend on the type of suits and
 * face value cards added to the builder using the addSuitsAndFaceValues method.
 */
public class DeckBuilder {
    private List<SuitFaceValueLists> suitsFaceValues = new ArrayList<>();
    private CardBuilder cardBuilder;
    private NumberGenerator generator;

    /**
     * Initialize the deck builder with a specific card builder. The card builder determines how to build
     * individual cards.
     * @param cardBuilder a CardBuilder to determine how to build each individual card.
     * @param generator a number generator to use for building the deck of cards.
     */
    public DeckBuilder(CardBuilder cardBuilder, NumberGenerator generator) {
        this.cardBuilder = cardBuilder;
        this.generator = generator;
    }

    /**
     * Add a list of suits that will be applied to each of the face value cards in the passed in list. This allows a
     * caller to easily describe the kind of deck to build. For example Suits: [Hearts, Spades] and FaceValues:
     * [Ace, Two, Seven] will create a deck of six cards consisting of ace, two, and seven heart and spade suits.
     * This method can be called multiple times to describe the type of deck to build.
     * @param suits a list of suits to use when building the deck.
     * @param faceValues a list of face value enums to use when building the deck.
     */
    public void addSuitsAndFaceValues(List<Suit> suits, List<FaceValue> faceValues) {
        suitsFaceValues.add(new SuitFaceValueLists(suits, faceValues));
    }

    /**
     * Build the deck based on the suits and face values added to the builder.
     * @return a deck of card objects. The card builder is used to create each individual card.
     */
    public Deck<Card> buildDeck() {
        ArrayList<Card> cards = new ArrayList<>();
        for (SuitFaceValueLists sFV : suitsFaceValues) {
            for (Suit suit : sFV.suits) {
                for (FaceValue fv : sFV.faceValues) {
                    cards.add(cardBuilder.buildCard(suit, fv));
                }
            }
        }
        Card[] cardArr = new Card[cards.size()];
        cards.toArray(cardArr);
        return new StandardDeck<>(cardArr, this.generator);
    }

    /**
     * This class is a helper to keep a pairing of suits and face values to build.
     */
    private class SuitFaceValueLists {
        private List<Suit> suits;
        private List<FaceValue> faceValues;

        /**
         * Creates a pairing of a list of suits and a list of face values.
         * @param suits a list of suits.
         * @param faceValues a list of face values.
         */
        private SuitFaceValueLists(List<Suit> suits, List<FaceValue> faceValues) {
            this.suits = suits;
            this.faceValues = faceValues;
        }
    }
}
