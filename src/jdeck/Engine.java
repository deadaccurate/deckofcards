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
public class Engine
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int iterations = 0;
        if (args.length != 1)
        {
            System.out.println("Usage: decktest <num iterations>");
            return;
        }
        
        try
        {
            iterations = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid arguement");
        }
        
        HashMap<Card, int[]> stats = new HashMap<Card, int[]>();
        setupHashMap(stats);
        for (int i = 0; i < iterations; ++i)
        {
            dealCardsOneShuffle(stats);
        }
        Set<Entry<Card,int[]>> statsInfo = stats.entrySet();
        Entry<Card, int[]>[] entries = (Entry<Card, int[]>[])statsInfo.toArray();
        printStat(entries[0]);
    }
    
    private static void printStat(Entry<Card, int[]> entry)
    {
        System.out.println("Card Info:\n" + entry.getKey());
        System.out.println("Stats:\n");
        int[] statsArr = entry.getValue();
        
        for (int i = 0; i < statsArr.length; ++i)
        {
            System.out.format("    Index[%d]: %d\n", i, statsArr[i]);
        }
    }
    
    private static void setupHashMap(HashMap<Card, int[]> stats)
    {
        Deck initDeck = new Deck();
        int initDeckSize = initDeck.getSize();
        Card curCard = null;
        while ((curCard = initDeck.dealOneCard()) != null)
        {
            int[] array = new int[initDeckSize];
            // default value for int is zero
            stats.put(curCard, array);
        }
    }
    
    private static void dealCardsOneShuffle(HashMap<Card, int[]> stats)
    {
        Deck cardDeck = new Deck();
        // Get the initial deck size so I know how many times to loop
        int initSize = cardDeck.getSize();
        // randomize the deck
        cardDeck.shuffle();
        for (int i = initSize - 1; i >= 0; --i)
        {
            Card curCard = cardDeck.dealOneCard();
            int[] occurArr = stats.get(curCard);
            occurArr[i] = occurArr[i] + 1;
        }
    }
}
