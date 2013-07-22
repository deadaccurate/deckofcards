package jdeck;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class defines tests for the FaceValue class.
 * @author jon
 *
 */
public class FaceValueTests
{
    /**
     * This method tests to make sure that the description is assigned
     * correctly.
     */
    @Test
    public void testGetDescription()
    {
        String name = "Ace";
        FaceValue val = new FaceValue(name, 1);
        assertEquals(val.getDescription(), name);
    }

    /**
     * This method tests to make sure that the value is assigned correctly.
     */
    @Test
    public void testGetValue()
    {
        int val = 2;
        FaceValue fVal = new FaceValue("Two", val);
        assertEquals(fVal.getValue(), val);
    }
    
    /**
     * This method tests if the equals method identifies two FaceValue objects
     * as equivalent.
     */
    @Test
    public void testEquals()
    {
        FaceValue fVal = new FaceValue("Two", 1);
        FaceValue fVal2 = new FaceValue("Two", 1);
        assertEquals(fVal, fVal2);
    }
    
    /**
     * This method tests if the equals method identifies two FaceValue objects
     * that are not equivalent.
     */
    @Test
    public void testNotEqualName()
    {
        FaceValue fVal = new FaceValue("Tw", 1);
        FaceValue fVal2 = new FaceValue("Two", 1);
        assertFalse(fVal.equals(fVal2));
    }
    
    /**
     * This method tests if the equals method identifies two FaceValue objects
     * that are not equivalent.
     */
    @Test
    public void testNotEqualVal()
    {
        FaceValue fVal = new FaceValue("Two", 1);
        FaceValue fVal2 = new FaceValue("Two", 2);
        assertFalse(fVal.equals(fVal2));
    }
    
    /**
     * This method tests if the equals method identifies if two references to
     * the same object are the same.
     */
    @Test
    public void testEqualRef()
    {
        FaceValue fVal = new FaceValue("Two", 1);
        FaceValue fVal2 = fVal;
        assertTrue(fVal2.equals(fVal));
    }
    
    /**
     * This method tests if the equals method identifies if two different
     * objects are not equal.
     */
    @Test
    public void testNotEqualsInstanceof()
    {
        FaceValue fVal = new FaceValue("Two", 2);
        String two = "Two";
        assertFalse(fVal.equals(two));
    }
    
    /**
     * This method tests if the hash code for two objects that are the same
     * is the same.
     */
    @Test
    public void testHashCode()
    {
        FaceValue fVal = new FaceValue("Two", 1);
        FaceValue fVal2 = new FaceValue("Two", 1);
        assertEquals(fVal.hashCode(), fVal2.hashCode());
    }
}
