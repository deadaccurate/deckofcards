package jdeck;
import jdeck.Suit;
import jdeck.FaceValue;

/**
 * This class defines the information for a card that makes up a deck.
 * A card contains a suit and a value.
 * @author jon
 *
 */
public class Card
{
    // The defined suit of this cards
    private Suit suit;
    // The value of this card
    private FaceValue value;
    
    /**
     * This constructor simply assigns the passed parameters to the instance
     * variables.
     * 
     * @param cardSuit is used as Suit of this card
     * @param faceVal is the FaceValue (the value) of this card
     */
    public Card(Suit cardSuit, FaceValue faceVal)
    {
        suit = cardSuit;
        value = faceVal;
    }
    
    /**
     * This method overrides the default toString() method.
     * It returns a string representation of the card's suit and value.
     * 
     * @return a String representation of the card
     */
    public @Override String toString()
    {
        return "SUIT\n" + suit + "\nVALUE\n" + value;
    }
    
    /**
     * This getter returns the card's suit.
     * 
     * @return the Suit of the card
     */
    public Suit getSuit()
    {
        return suit;
    }
    
    /**
     * This getter returns the value of the card.
     * 
     * @return the FaceValue of the card
     */
    public FaceValue getFaceValue()
    {
        return value;
    }
}
