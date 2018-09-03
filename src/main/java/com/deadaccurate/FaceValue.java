package com.deadaccurate;

/**
 * This class represents the possible face values of a card.
 */
public enum FaceValue {
    Ace(1, "Ace"),
    Two(2, "Two"),
    Three(3, "Three"),
    Four(4, "Four"),
    Five(5, "Five"),
    Six(6, "Six"),
    Seven(7, "Seven"),
    Eight(8, "Eight"),
    Nine(9, "Nine"),
    Ten(10, "Ten"),
    Jack(11, "Jack"),
    Queen(12, "Queen"),
    King(13, "King");

    private final int value;
    private final String name;

    /**
     * Initialize the numeric value and name.
     * @param value the numeric value of the card.
     * @param name the string representation of the face value of the card.
     */
    FaceValue(int value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * Returns the numeric value.
     * @return an int representing the numeric value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the string representation of the face value.
     * @return a string name.
     */
    public String getName() {
        return name;
    }
}
