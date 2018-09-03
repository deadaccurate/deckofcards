package com.deadaccurate;

/**
 * This interface is a wrapper around Java's Random class. This will allow me to mock the Random class used
 * for implementing the shuffle method in the Deck class.
 */
public interface NumberGenerator {
    /**
     * Retrieve an integer from the generator.
     * @param bound is the upper bound (exclusive) number to generate. It must be positive.
     * @return the next number from the generator.
     */
    int nextInt(int bound);
}
