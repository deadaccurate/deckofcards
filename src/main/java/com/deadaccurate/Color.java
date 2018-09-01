package com.deadaccurate;

/**
 * Color represents the Red and Black suit colors of a Card.
 */
public enum Color {
    Red("Red"),
    Black("Black");

    private final String name;

    /**
     * Color constructor initializes the enum's color name.
     * @param name The string name of the color.
     */
    Color(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the color.
     * @return a String representation of the name.
     */
    public String getName() {
        return name;
    }
}
