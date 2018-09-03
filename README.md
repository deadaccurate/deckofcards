# Deck of cards implementation
This library implements a deck of cards with the ace as high
(valued greater than King). The Ace class can be instantiated as low or high.
The PokerDeckBuilder creates a deck with the ace as high.

## Project Layout
- libraries [lib](https://github.com/deadaccurate/deckofcards/tree/master/lib)
- source code [src/main/java](https://github.com/deadaccurate/deckofcards/tree/master/src/main/java/)
- unit tests [src/main/test](https://github.com/deadaccurate/deckofcards/tree/master/src/test/java/)

## Design
My hope was to make the library extensible to allow other types of decks to easily be
created. For example if the ace needs to be low, a different PokerDeckBuilder
function could be added to support that.

I decided not to unit test the randomness of shuffle but instead that it swaps cards as expected.
For better testability, the StandardDeck class takes a NumberGenerator
to allow shuffle's functionality to be predictable.

The shuffle and dealOneCard methods are implemented in [StandardDeck](https://github.com/deadaccurate/deckofcards/blob/master/src/main/java/com/deadaccurate/StandardDeck.java).
