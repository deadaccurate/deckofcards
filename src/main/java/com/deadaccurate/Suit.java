package com.deadaccurate;

/**
 * The Suit class defines the color and suit value of a card.
 */
public enum Suit {
    Hearts("Hearts", Color.Red),
    Spades("Spades", Color.Black),
    Clubs("Clubs", Color.Black),
    Diamonds("Diamonds", Color.Red);

    private final String name;
    private final Color color;

    /**
     * Initializes a Suit with a numerical value, a name, and a color.
     * @param name the string name of the suit.
     * @param color the color of the suit.
     */
    Suit(String name, Color color) {
        this.name = name;
        this.color = color;
    }


    /**
     * Returns the name of the suit.
     * @return the string representation of the suit.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the color of the suit.
     * @return a Color enum of the suit.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Builds and returns a string describing the suit's name, value, and color.
     * @return a string describing the suit.
     */
    @Override
    public String toString() {
        return "Suit: name: " + name + " color: " + color.getName();
    }
}
