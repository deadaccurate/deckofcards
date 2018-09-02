package com.deadaccurate;

/**
 * CardBuilder requires a buildCard method which will create a new Card object or subclass of Card. This interface is
 * used to allow different implementation of a card to be created for different deck types. For example a deck that
 * needs Aces to be 1 can build the appropriate ace when that type face value is encountered.
 */
public interface CardBuilder {
    /**
     * Build a card object based on the suit and face value requested.
     * @param suit the card's suit type.
     * @param faceValue the face value of the card to build.
     * @return a newly built Card object representing the suit and face value requested.
     */
    Card buildCard(Suit suit, FaceValue faceValue);
}
