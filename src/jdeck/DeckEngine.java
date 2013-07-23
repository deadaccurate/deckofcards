package jdeck;

import jdeck.Card;
import jdeck.Deck;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Class is used to exercise the shuffling algorithm of the Deck class. It will
 * keep track of the index of each card after the shuffle method is called.
 * @author jon
 *
 */
public class DeckEngine
{
    /**
     * This function is called at the start of the program. It checks for a
     * single argument specifying the number of runs.
     * 
     * @param args contains the passed in values
     */
    public static void main(String[] args)
    {
        int iterations = 0;
        if (args.length != 1)
        {
            System.out.println("Usage: DeckEngine <num iterations>");
            return;
        }
        
        try
        {
            iterations = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid arguement must be an integer");
        }
        
        // HashMap will be used to identify when a card is being used in an
        // array index.
        HashMap<Card, int[]> stats = new HashMap<Card, int[]>();
        // Fill the hash map will 52 cards and an associated empty array of
        // integers
        setupHashMap(stats);
        
        // Deal the deck out and see where each Card lands in the shuffled
        // array. The loop runs the specified number of iterations
        Card errorCard = null;
        for (int i = 0; i < iterations; ++i)
        {
            if ((errorCard = dealCardsOneShuffle(stats)) != null)
            {
                System.out.println("The hash map could not find the card " +
                        errorCard);
            }
        }
        // Print the statistics for each card:
        // Card info
        //     Array index 0 - 51: number of times card was in that index
        printStat(stats.entrySet());
    }
    
    /**
     * This function is used to print the collect statistics after a given
     * number of deal.
     * 
     * @param entrySet is a set representing the entry hashmap used to gather
     * statistics.
     */
    private static void printStat(Set<Entry<Card, int[]>> entrySet)
    {
        // Loop over all 52 cards in the hash map
        for (Entry<Card, int[]> e : entrySet)
        {
            int[] statsArr = e.getValue();
            // Print the card information (suit and value)
            System.out.println(e.getKey());
            // Loop over each array index (52) and print the number of times
            // this card ended up in that array slot
            for (int index = 0; index < statsArr.length; ++index)
            {
                System.out.format("    %d:\t%d\n", index, statsArr[index]);
            }
        }
    }
    
    /**
     * This function sets up the hash map by dealing a deck to the map which
     * puts each of the 52 cards in the map as keys and an empty array of
     * 52 ints as values. The array will be used to keep track of each
     * slot that the card ended up in.
     * 
     * @param stats is a hash map used to gather statistics
     */
    private static void setupHashMap(HashMap<Card, int[]> stats)
    {
        // This deck is simply used to get 1 of each card in the hash map
        Deck initDeck = new Deck();
        // Get the size so we know how big the array of ints should be
        int initDeckSize = initDeck.getSize();
        Card curCard = null;
        // While there are still cards in the deck
        while ((curCard = initDeck.dealOneCard()) != null)
        {
            int[] array = new int[initDeckSize];
            // default value for int is zero
            stats.put(curCard, array);
        }
    }
    
    /**
     * This function is used to deal all the cards in the deck after a single
     * shuffle is called. After a card is dealt it records which position and
     * updates the statistics for that card in that position. This function
     * will return a Card if it wasn't found within the hash map.
     * 
     * @param stats is used to gather statistics on how the deck is dealt
     * @return null if everything is ok, a Card if it wasn't found in the hashMap
     */
    private static Card dealCardsOneShuffle(HashMap<Card, int[]> stats)
    {
        Deck cardDeck = new Deck();
        // Get the initial deck size so I know how many times to loop
        int initSize = cardDeck.getSize();
        // randomize the deck
        cardDeck.shuffle();
        // Start backwards because the deck deals from the end of the array
        // (high index)
        for (int i = initSize - 1; i >= 0; --i)
        {
            Card curCard = cardDeck.dealOneCard();
            int[] occurArr = stats.get(curCard);
            if (occurArr != null)
            {
                occurArr[i] = occurArr[i] + 1;
            }
            else
            {
                return curCard;
            }
        }
        return null;
    }
}
