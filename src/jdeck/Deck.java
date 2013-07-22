package jdeck;

import jdeck.Card;
import jdeck.Suit;
import jdeck.FaceValue;
import java.util.Random;

/**
 * This class defines a deck of cards. It creates 52 cards using an array.
 * It defines methods to shuffle and deal a card from the deck. After dealing
 * part of the deck, the left over cards can be shuffled again.
 * 
 * @author jon
 *
 */
public class Deck
{
    // A helper string to initialize the red suits
    private static final String RED = "Red";
    // A helper string to initialize the black suits
    private static final String BLACK = "Black";
    // Four possible suits. I am using an array to hold the suits
    // so I can easily construct a deck of cards with the appropriate suits
    // by simply looping through suits
    private static final Suit[] SUITS = {
        new Suit("Heart", RED),
        new Suit("Diamond", RED),
        new Suit("Club", BLACK),
        new Suit("Spade", BLACK)
    };
    // This variable is used to help initialize the different types of cards
    // This array specifies the types of cards.
    private static final String[] DESCRIPTIONS = {
        "Ace",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Jack",
        "Queen",
        "King",
    };
    // Create a FaceValue array to hold the different type of cards that will
    // be within this Deck
    // The array has to be the same length as the DESCRIPTIONS variable
    // so that both can be iterated through to initialize each card type
    private static final FaceValue[] FACE_VALUES =
            new FaceValue[DESCRIPTIONS.length];
   
    // This variable defines the cards associated with this deck. An array is
    // being used to allow for easy shuffling of the cards.
    private Card[] cards;
    // This variable holds the current size of the deck. After a call to
    // dealOneCard size will be decremented by one if the deck has any cards
    // left.
    private int size;
    
    /**
     * Default constructor to initialize the deck with 52 cards. The deck will
     * contain 13 cards of each suit.
     */
    public Deck()
    {
        size = SUITS.length * FACE_VALUES.length;
        cards = new Card[size];
        
        // Initialize the different types of cards with their value
        // and description
        for (int i = 0; i < DESCRIPTIONS.length; ++i)
        {
            FACE_VALUES[i] = new FaceValue(DESCRIPTIONS[i], i + 1);
        }
        
        // Initialize the cards array with 13 cards in each suit
        for (int curSuit = 0; curSuit < SUITS.length; ++curSuit)
        {
            for (int curVal = 0; curVal < FACE_VALUES.length; ++curVal)
            {
                cards[(curSuit * FACE_VALUES.length) + curVal] = new Card(SUITS[curSuit], FACE_VALUES[curVal]);
            }
        }
    }
    
    /**
     * This method randomizes the current deck of cards. This method can be
     * called after calling dealOneCard(). The algorithm used to randomize
     * the cards is the Knuth shuffle algorithm. It iterates over the current
     * deck in reverse order. It generates a random number and swaps the value
     * at that index with the current iteration index.
     */
    public void shuffle()
    {
        Random ranGen = new Random();
        for (int i = size - 1; i >= 1; --i)
        {
            // i + 1 because nextInt() upper bound is exclusive and I want to
            // allow a card to not be swapped
            int swapIndex = ranGen.nextInt(i + 1);
            // swap the cards
            Card swapCard = cards[i];
            cards[i] = cards[swapIndex];
            cards[swapIndex] = swapCard;
        }
    }

    /**
     * Calling this method returns a card from the deck. If no cards are left
     * in the deck then null is returned.
     * 
     * @return a Card object from the array or null if the deck is empty.
     */
    public Card dealOneCard()
    {
        Card retCard = null;

        if (size > 0)
        {
            --size;
            retCard = cards[size];
            cards[size] = null;
        }

        return retCard;
    }
    
    /**
     * This method is used to retrieve the current size of the deck.
     */
    public int getSize()
    {
        return size;
    }
}
