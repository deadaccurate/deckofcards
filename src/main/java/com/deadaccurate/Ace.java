package com.deadaccurate;

/**
 * The Ace class allows the ace card to be low (face value of 1) or high (face value of 11).
 */
public class Ace extends Card {
    private boolean isLow;

    /**
     * Initialize the Ace class with the necessary card information and if it is low or high.
     * @param suit the suit of the ace.
     * @param isLow a boolean defining if the ace is low or high.
     */
    public Ace(Suit suit, boolean isLow) {
        super(suit, FaceValue.Ace);
        this.isLow = isLow;
    }

    /**
     * Return the value of the Ace depending on if it was initalized as low or high.
     * @return 1 if the Ace is low and 11 and if the Ace is high.
     */
    @Override
    public int getValue() {
        // high is greater than a King
        return isLow ? 1 : 14;
    }

    /**
     * Overriding the Card class's equal to compare the isLow field too.
     * @param o the other object to compare against.
     * @return True if the objects are equal, false if otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Ace ace = (Ace) o;

        return isLow == ace.isLow;
    }

    /**
     * Generates a unique integer for the Ace object.
     * @return a unique integer for the object.
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isLow ? 1 : 0);
        return result;
    }
}
