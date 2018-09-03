package com.deadaccurate;

/**
 * StandardDeck holds cards ready to be shuffled and dealt. It uses Knuth's shuffling algorithm to shuffle the deck.
 * As cards are dealt they are removed and replaced with a null value.
 * @param <T> A card type that extends the Card class.
 */
public class StandardDeck<T extends Card> implements Deck<T> {

    private NumberGenerator generator;
    private int size;
    private T[] cards;

    /**
     * Initialize the deck with an array of generic cards and a number generator used to shuffle the deck.
     * @param cards an array of generic card type that extends Cards.
     * @param generator a number generator used to retrieve numbers and shuffle the deck.
     */
    public StandardDeck(T[] cards, NumberGenerator generator) {
        this.cards = cards;
        this.generator = generator;
        this.size = this.cards.length;
    }

    /**
     * Internally shuffles the contents of the deck.
     * This method randomizes the current deck of cards. This method can be
     * called after calling dealOneCard(). The algorithm used to randomize
     * the cards is the Knuth shuffle algorithm. It iterates over the current
     * deck in reverse order. It generates a random number and swaps the value
     * at that index with the current iteration index.
     */
    @Override
    public void shuffle() {
        // size - 1 to stay in array bounds
        for (int i = size - 1; i >= 1; --i) {
            // i + 1 because nextInt bound is exclusive, so to allow for the possibility of cards to stay in the same
            // position need to add 1
            int swapIndex = generator.nextInt(i + 1);
            // if for some reason we get a crazy number not within our bounds skip it.
            if (swapIndex >= size || swapIndex < 0) {
                continue;
            }
            T swapCard = cards[i];
            cards[i] = cards[swapIndex];
            cards[swapIndex] = swapCard;
        }
    }

    /**
     * Removes and returns a card from the deck.
     *
     * @return a card class that extends Card.
     */
    @Override
    public T dealOneCard() {
        T card = null;
        if (size > 0) {
            --size;
            card = cards[size];
            cards[size] = null;
        }
        return card;
    }

    /**
     * Returns the number of cards left in the deck.
     *
     * @return an integer representing the number of cards left in the deck.
     */
    @Override
    public int size() {
        return size;
    }
}
