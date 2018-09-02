package com.deadaccurate;

/**
 * Deck interface requires the shuffle and dealOneCard methods. Card decks can have a variable number of cards depending
 * on the game being played. All decks must be shuffled and be able to deal cards.
 * @param <T> Type of cards in the deck.
 */
public interface Deck <T extends Card> {
    /**
     * Internally shuffles the contents of the deck.
     */
    void shuffle();

    /**
     * Removes and returns a card from the deck.
     * @return a card class that extends Card.
     */
    T dealOneCard();

    /**
     * Returns the number of cards left in the deck.
     * @return an integer representing the number of cards left in the deck.
     */
    int size();
}
