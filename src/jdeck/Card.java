package jdeck;
import jdeck.Suit;
import jdeck.FaceValue;

public class Card
{
    private Suit suit;
    private FaceValue value;
    
    public Card(Suit cardSuit, FaceValue faceVal)
    {
        suit = cardSuit;
        value = faceVal;
    }
    
    public Suit getSuit()
    {
        return suit;
    }
    
    public FaceValue getFaceValue()
    {
        return value;
    }
}
