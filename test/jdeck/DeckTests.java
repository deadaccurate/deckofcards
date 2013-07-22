package jdeck;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.HashSet;

/**
 * This class defines tests for the Deck class. Specifically it will test the
 * shuffle and dealOneCard routines.
 * @author jon
 *
 */
public class DeckTests
{
    // A Deck instance to use during tests
    private Deck cardDeck;
    // A Deck used for verification (will be constructed using the defined suits
    // and FaceValue in this Test class
    private HashSet<Card> verDeck;
    // These will be used to check if the deck has 13 cards of each suit
    private static final Suit[] SUITS = {
        new Suit("Heart", "Red"),
        new Suit("Diamond", "Red"),
        new Suit("Club", "Black"),
        new Suit("Spade", "Black")
    };
    // These will be used to check if each card value is in the deck
    private static final FaceValue[] FACE_VALUES = {
        new FaceValue("Ace", 1),
        new FaceValue("Two", 2),
        new FaceValue("Three", 3),
        new FaceValue("Four", 4),
        new FaceValue("Five", 5),
        new FaceValue("Six", 6),
        new FaceValue("Seven", 7),
        new FaceValue("Eight", 8),
        new FaceValue("Nine", 9),
        new FaceValue("Ten", 10),
        new FaceValue("Jack", 11),
        new FaceValue("Queen", 12),
        new FaceValue("King", 13)
    };
    
    /**
     * This method simply creates a Deck object to be used during the tests.
     */
    @Before
    public void setUp()
    {
        cardDeck = new Deck();
        verDeck = new HashSet<Card>();
        // Build the verification deck
        for (Suit s : SUITS)
            for (FaceValue fv : FACE_VALUES)
                verDeck.add(new Card(s, fv));
    }
    
    /**
     * This method tests that calling dealOneCard will return a card from
     * the deck if there are cards left.
     */
    @Test
    public void testDealOneCard()
    {
        cardDeck.shuffle();
        assertNotNull(cardDeck.dealOneCard());
        cardDeck.shuffle();
        assertNotNull(cardDeck.dealOneCard());
    }
    
    /**
     * This method tests that the Deck class only returns 52 cards.
     */
    @Test
    public void testDealAllCards()
    {
        int totalSize = cardDeck.getSize();
        for (int i = 0; i < totalSize; ++i)
        {
            assertNotNull(cardDeck.dealOneCard());
        }
        assertNull(cardDeck.dealOneCard());
    }
    
    /**
     * This method tests that a deck contains 52 cards, 13 Hearts, Spaces,
     * Diamonds, and Clubs.
     */
    @Test
    public void testAllCards()
    {
        cardDeck.shuffle();
        Card curCard = null;
        for (int i = 0; i < 52; ++i)
        {
            curCard = cardDeck.dealOneCard();
            assertNotNull(curCard);
            assertTrue(verDeck.remove(curCard));
        }
        // Make sure the deck is empty after 52 deals
        assertEquals(cardDeck.getSize(), 0);
        // Make sure all the cards in the verification deck are gone too
        assertEquals(verDeck.size(), 0);
    }
    
    /**
     * This method tests that the getSize() method correctly returns the number
     * of cards in the deck.
     */
    @Test
    public void testGetSize()
    {
        assertEquals(cardDeck.getSize(), 52);
        cardDeck.dealOneCard();
        assertEquals(cardDeck.getSize(), 51);
    }
}
