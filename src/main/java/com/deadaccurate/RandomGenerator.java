package com.deadaccurate;

import java.security.SecureRandom;

/**
 * Generates random numbers. This class wraps SecureRandom. SecureRandom is used because it uses a larger seed which
 * will result in more permutations of the deck.
 */
public class RandomGenerator implements NumberGenerator {
    private SecureRandom generator = new SecureRandom();

    /**
     * Return a random number using SecureRandom within the bound specified.
     * @param bound is the upper bound (exclusive) number to generate. It must be positive.
     * @return a random number.
     */
    public int nextInt(int bound) {
        return generator.nextInt(bound);
    }
}
