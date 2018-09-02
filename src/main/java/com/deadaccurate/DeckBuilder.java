package com.deadaccurate;

import java.util.ArrayList;
import java.util.List;

public class DeckBuilder {
    private List<SuitFaceValueLists> suitsFaceValues = new ArrayList<>();
    private CardBuilder cardBuilder;

    public DeckBuilder(CardBuilder cardBuilder) {
        this.cardBuilder = cardBuilder;
    }

    public void addSuitsAndFaceValues(List<Suit> suits, List<FaceValue> faceValues) {
        suitsFaceValues.add(new SuitFaceValueLists(suits, faceValues));
    }

    public Deck<Card> buildDeck() {
        ArrayList<Card> cards = new ArrayList<>();
        for (SuitFaceValueLists sFV : suitsFaceValues) {
            for (Suit suit : sFV.suits) {
                for (FaceValue fv : sFV.faceValues) {
                    cards.add(cardBuilder.buildCard(suit, fv));
                }
            }
        }
        return null;
    }

    private class SuitFaceValueLists {
        private List<Suit> suits;
        private List<FaceValue> faceValues;

        private SuitFaceValueLists(List<Suit> suits, List<FaceValue> faceValues) {
            this.suits = suits;
            this.faceValues = faceValues;
        }
    }
}
