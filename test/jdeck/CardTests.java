package jdeck;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

/**
 * This class defines tests for the Card class.
 * @author jon
 */
public class CardTests
{
    // A Suit to be used when creating a Card object
    private Suit suit;
    // A FaceValue object to be used when creating a Card object
    private FaceValue val;
    
    /**
     * This method is run before each test to create the necessary pieces of
     * a Card.
     */
    @Before
    public void setUp()
    {
        suit = new Suit("Heart", "Red");
        val = new FaceValue("Ace", 1);
    }
    
    /**
     * This method tests that the Suit is assigned to Card correctly.
     */
    @Test
    public void testGetSuit()
    {
        Card card = new Card(suit, val);
        assertEquals(card.getSuit(), suit);
    }
    
    /**
     * This method tests that the FaceValue is assigned to the Card correctly.
     */
    @Test
    public void testGetFaceValue()
    {
        Card card = new Card(suit, val);
        assertEquals(card.getFaceValue(), val);
    }
    
    /**
     * This method tests that two cards are equal.
     */
    @Test
    public void testEquals()
    {
        Card card = new Card(suit, val);
        Suit otherSuit = new Suit("Heart", "Red");
        FaceValue otherFV = new FaceValue("Ace", 1);
        Card otherCard = new Card(otherSuit, otherFV);
        assertEquals(otherCard, card);
    }
    
    /**
     * This method tests that two variables that reference the same card
     * are equal.
     */
    @Test
    public void testRefEquals()
    {
        Card card = new Card(suit, val);
        Card otherCard = card;
        assertEquals(otherCard, card);
    }
    
    /**
     * This method tests that a null object and a Card object are not equal.
     */
    @Test
    public void testNullRef()
    {
        Card card = new Card(suit, val);
        assertFalse(card.equals(null));
    }
    
    /**
     * This method tests that a different type of object does not equal a Card.
     */
    @Test
    public void testNotInstanceof()
    {
        Card card = new Card(suit, val);
        assertFalse(card.equals(val));
    }
    
    /**
     * This method tests if the hash code for the two objects that are equal
     * is the same.
     */
    @Test
    public void testHashCodeEqual()
    {
        Card card = new Card(suit, val);
        Suit s = new Suit("Heart", "Red");
        FaceValue fv = new FaceValue("Ace", 1);
        Card card2 = new Card(s, fv);
        assertEquals(card.hashCode(), card2.hashCode());
    }
}
