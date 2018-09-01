package com.deadaccurate;

import org.junit.Assert;
import org.junit.Test;

/**
 * ColorTest contains tests for the Color enum class.
 */
public class ColorTest {
    /**
     * Test that the Color's name equals the correct color string.
     */
    @Test
    public void testGetName() {
        Assert.assertEquals(Color.Red.getName(), "Red");
        Assert.assertEquals(Color.Black.getName(), "Black");
    }
}
