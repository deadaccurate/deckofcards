package com.deadaccurate;

/**
 * Card defines the fields of an individual card. A card contains a suit and face value.
 */
public class Card {
    private final Suit suit;
    private final FaceValue faceValue;

    /**
     * Initialize the card with a suit and face value.
     * @param suit is Suit enum defining the type of card.
     * @param value is a FaceValue enum defining the value of the card.
     */
    public Card(Suit suit, FaceValue value) {
        this.suit = suit;
        this.faceValue = value;
    }

    /**
     * Return the numeric value of the card.
     * @return an int representing the numeric value of the card.
     */
    public int getValue() {
        return faceValue.getValue();
    }

    /**
     * Return the card's face value as an enum.
     * @return a FaceValue enum of the card's.
     */
    public FaceValue getFaceValue() {
        return faceValue;
    }

    /**
     * Return the card's suit.
     * @return a Suit enum for the card.
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Custom equals method to compare two objects.
     * @param o the other object to compare against.
     * @return true if the object's classes and fields are the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (getSuit() != card.getSuit()) return false;
        return getFaceValue() == card.getFaceValue();
    }

    /**
     * Custom hash code generating method.
     * @return a unique integer for the specific fields of this class.
     */
    @Override
    public int hashCode() {
        int result = getSuit() != null ? getSuit().hashCode() : 0;
        result = 31 * result + (getFaceValue() != null ? getFaceValue().hashCode() : 0);
        return result;
    }
}
