package com.deadaccurate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class tests the RandomGenerator to ensure it returns numbers within the bounds requested.
 */
public class RandomGeneratorTest {

    /**
     * Test that the generator returns an integer within the requested bounds.
     */
    @Test
    public void testNextInt() {
        RandomGenerator rand = new RandomGenerator();
        assertEquals(rand.nextInt(1), 0);
        assertEquals(rand.nextInt(1), 0);
        int num = rand.nextInt(5);
        assertTrue(num <= 4 && num >= 0);
    }
}
