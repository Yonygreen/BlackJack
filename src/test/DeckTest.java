import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void deckNotNull(){
        Deck deck = new Deck();
        assertNotNull(deck.getDeck());
    }

    @Test
    void deckSize52(){
        Deck deck = new Deck();
        assertEquals(52, deck.getDeckSize());
    }

    @Test
    void deckSize2(){
        Deck deck = new Deck();
        deck.getDeck().subList(0,50).clear(); // Removes 50 cards from deck
        assertEquals(2, deck.getDeckSize());
    }

    @Test
    void deckShuffleWorks(){
        Deck deck = new Deck();
        deck.shuffle();
        Card topCard = deck.getDeck().get(0); // Getting the top card from the shuffled deck
        deck.shuffle();
        Card newTopCard = deck.getDeck().get(0); // Getting the top card from the newly shuffled deck
        assertNotEquals(topCard, newTopCard);
    }
}