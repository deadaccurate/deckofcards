package jdeck;

import jdeck.Card;
import jdeck.Suit;
import jdeck.FaceValue;

public class Deck
{
    private static final String RED = "Red";
    private static final String BLACK = "Black";
    private static final Suit[] SUITS = {
        new Suit("Heart", RED),
        new Suit("Diamond", RED),
        new Suit("Club", BLACK),
        new Suit("Spade", BLACK)
    };
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
    private static final FaceValue[] FACE_VALUES = new FaceValue[DESCRIPTIONS.length];
    
    private Card[] cards;
    private int size;
    
    public Deck()
    {
        size = SUITS.length * FACE_VALUES.length;
        cards = new Card[size];

        for (int i = 0; i < DESCRIPTIONS.length; ++i)
        {
            FACE_VALUES[i] = new FaceValue(DESCRIPTIONS[i], i + 1);
        }
        
        for (int curSuit = 0; curSuit < SUITS.length; ++curSuit)
        {
            for (int curVal = 0; curVal < FACE_VALUES.length; ++curVal)
            {
                cards[(curSuit * FACE_VALUES.length) + curVal] = new Card(SUITS[curSuit], FACE_VALUES[curVal]);
            }
        }
    }
    
    public void shuffle()
    {

    }

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
}
