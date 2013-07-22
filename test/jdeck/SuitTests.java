package jdeck;

import static org.junit.Assert.*;
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
    
    /**
     * This method tests that the equals method identifies if two objects
     * are the same.
     */
    @Test
    public void testEquals()
    {
        Suit s = new Suit("H", "b");
        Suit s2 = new Suit("H", "b");
        assertTrue(s.equals(s2));
    }
    
    /**
     * This method tests that the equals method identifies that two references
     * to the same object are the same.
     */
    @Test
    public void testEqualRef()
    {
        Suit s = new Suit("h", "b");
        Suit refS = s;
        assertTrue(s.equals(refS));
    }
    
    /**
     * This method tests that the equals method identifies when two objects
     * are not of the same type.
     */
    @Test
    public void testNotEqualInstof()
    {
        Suit s = new Suit("h", "b");
        String str = "hello";
        assertFalse(s.equals(str));
    }
    
    /**
     * This method tests that the equals method does not equuate a Suit object
     * with null.
     */
    @Test
    public void testEqualNull()
    {
        Suit s = new Suit("h", "a");
        assertFalse(s.equals(null));
    }
    
    /**
     * This method tests that the hash code of two equal objects is the same.
     */
    @Test
    public void testHashCode()
    {
        Suit s = new Suit("a", "b");
        Suit s2 = new Suit("a", "b");
        assertEquals(s.hashCode(), s2.hashCode());
    }
}
