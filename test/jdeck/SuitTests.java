package jdeck;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * This class defines tests for the Suit class.
 * @author jon
 *
 */
public class SuitTests
{
    /**
     * This test validates that the name assigned to a Suit during the
     * instance's creation is truly assigned. It exercises the name getter
     * method.
     */
    @Test
    public void testGetName()
    {
        String heart = "Heart";
        Suit testSuit = new Suit(heart, "Green");
        assertEquals(testSuit.getName(), heart);
    }
    
    /**
     * This test validates that the color assigned to a Suit during the
     * instance's creation is truly assigned by exercising the color getter.
     */
    @Test
    public void testGetColor()
    {
        String blue = "Blue";
        Suit testSuit = new Suit("Heart", blue);
        assertEquals(testSuit.getColor(), blue);
    }
}
