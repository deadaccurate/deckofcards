package com.deadaccurate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ColorTest contains tests for the Color enum class.
 */
public class ColorTest {
    /**
     * Test that the Color's name equals the correct color string.
     */
    @Test
    public void testGetName() {
        assertEquals(Color.Red.getName(), "Red");
        assertEquals(Color.Black.getName(), "Black");
    }
}
