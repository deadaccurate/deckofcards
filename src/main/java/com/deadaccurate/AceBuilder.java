package com.deadaccurate;

/**
 * AceBuilder determines the type of Ace (low or high) to build. It builds the rest of the cards using the Card class.
 */
public class AceBuilder implements CardBuilder {
    private boolean isLow;

    /**
     * Creates an AceBuilder for low or high aces.
     * @param isLow a boolean flag to determine if the ace will be low (true) or high (false).
     */
    public AceBuilder(boolean isLow) {
        this.isLow = isLow;
    }

    /**
     * Builds a card based on the suit and face value. If it is an ace it creates an Ace object.
     * @param suit the card's suit type.
     * @param faceValue the face value of the card to build.
     * @return a Card object with the appropriate suit and face value.
     */
    public Card buildCard(Suit suit, FaceValue faceValue) {
        if (faceValue == FaceValue.Ace) {
            return new Ace(suit, isLow);
        }
        return new Card(suit, faceValue);
    }
}
