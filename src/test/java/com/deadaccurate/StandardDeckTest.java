package com.deadaccurate;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * These tests ensure that the StandardDeck class return the expected cards in the correct order.
 */
public class StandardDeckTest {
    private Card[] cards;
    private Card[] expCards;

    /**
     * Create an array of cards for the deck and a copy that will be used as the expected array when the deck is dealt.
     */
    @Before
    public void setUp() {
        cards = new Card[4];
        cards[0] = new Card(Suit.Spades, FaceValue.Nine);
        cards[1] = new Card(Suit.Hearts, FaceValue.Ace);
        cards[2] = new Card(Suit.Clubs, FaceValue.Three);
        cards[3] = new Card(Suit.Diamonds, FaceValue.King);
        expCards = new Card[cards.length];
        System.arraycopy(cards, 0, expCards, 0, cards.length);
    }

    /**
     * Reverses an array of cards in place.
     * @param cards an array of cards
     */
    private void reverse(Card[] cards) {
        for (int i = 0; i < cards.length / 2; ++i) {
            Card tmp = cards[i];
            cards[i] = cards[cards.length - i - 1];
            cards[cards.length - i - 1] = tmp;
        }
    }

    /**
     * Assert that a deck equals the expected array of cards.
     * @param deck a deck of cards to check the order of the cards.
     * @param exp is the expected ordering of cards.
     */
    private static void assertDeckEquals(Deck<Card> deck, Card[] exp) {
        // deal all the cards
        for (int i = exp.length - 1; i >= 0; --i) {
            assertEquals(deck.dealOneCard(), exp[i]);
        }
    }

    /**
     * Test that the size function returns the correct number for the remaining number of cards in the deck.
     */
    @Test
    public void testSize() {
        Deck<Card> deck = new StandardDeck<>(cards, new QueueNumberGenerator());
        assertEquals(deck.size(), cards.length);
        deck.dealOneCard();
        assertEquals(deck.size(), cards.length - 1);
        deck = new StandardDeck<>(new Card[0], new QueueNumberGenerator());
        assertEquals(deck.size(), 0);
    }

    /**
     * Test to make sure that if shuffle keeps the cards in the same order that the cards are dealt that way.
     */
    @Test
    public void testShuffleSameOrder() {
        // these values will keep the deck's cards in the same order
        Queue<Integer> nums = new LinkedList<>(Arrays.asList(3, 2, 1));
        Deck<Card> deck = new StandardDeck<>(cards, new QueueNumberGenerator(nums));
        deck.shuffle();
        // deal all the cards
        StandardDeckTest.assertDeckEquals(deck, expCards);
        // next card should be null because no cards are left in the deck
        assertNull(deck.dealOneCard());
    }

    /**
     * Test that shuffle will actually shuffle the cards in reverse order if the number generator returns all zeros.
     */
    @Test
    public void testShuffleReverse() {
        // Example: [S, H, C, D]
        // swap D with S: [D, H, C, S], i = 3, swap = 0
        // swap C with H: [D, C, H, S], i = 2, swap = 1
        // swap C with C: [D, C, H, S], i = 1, swap = 1
        // exit shuffle because i == 0
        Queue<Integer> nums = new LinkedList<>(Arrays.asList(0, 1, 1));
        Deck<Card> deck = new StandardDeck<>(cards, new QueueNumberGenerator(nums));
        reverse(expCards);
        deck.shuffle();
        StandardDeckTest.assertDeckEquals(deck, expCards);
    }

    /**
     * This test for a number generate that returns values out of range of the card deck.
     */
    @Test
    public void testShuffleNumberOutOfRange() {
        Queue<Integer> nums = new LinkedList<>(Arrays.asList(-1, 7, 12));
        Deck<Card> deck = new StandardDeck<>(cards, new QueueNumberGenerator(nums));
        deck.shuffle();
        StandardDeckTest.assertDeckEquals(deck, expCards);
    }

    /**
     * Test shuffle called after dealing a card.
     */
    @Test
    public void testShuffleAfterDealCard() {
        // [S, H, C, D] to [D, C, H, S]
        // deal -> S
        // deal -> H
        // shuffle:
        // [D, C] -> [C, D]
        // deal -> D
        // deal -> C
        Queue<Integer> nums = new LinkedList<>(Arrays.asList(0, 1, 1, 0));
        Deck<Card> deck = new StandardDeck<>(cards, new QueueNumberGenerator(nums));
        deck.shuffle();
        assertEquals(deck.dealOneCard(), new Card(Suit.Spades, FaceValue.Nine));
        assertEquals(deck.dealOneCard(), new Card(Suit.Hearts, FaceValue.Ace));
        deck.shuffle();
        assertEquals(deck.dealOneCard(), new Card(Suit.Diamonds, FaceValue.King));
        assertEquals(deck.dealOneCard(), new Card(Suit.Clubs, FaceValue.Three));
    }

    /**
     * Test shuffle when the deck is empty.
     */
    @Test
    public void testShuffleEmpty() {
        Deck<Card> deck = new StandardDeck<>(new Card[0], new QueueNumberGenerator());
        deck.shuffle();
        assertEquals(deck.size(), 0);
        assertNull(deck.dealOneCard());
    }
}
