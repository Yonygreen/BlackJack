import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        // Assigning an empty ArrayList to the deck.
        deck = new ArrayList<>();

        // Adding cards to the deck, every suit gets 13 cards from 1-K, resulting in a 52 card deck.
        for (Suits suit: Suits.values()){
            for (Ranks rank: Ranks.values()){
                Card card = new Card(suit.getSuitName(), rank.getName(), rank.getValue());
                deck.add(card);
            }
        }
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }

    public int getDeckSize() { return deck.size(); }


    // Shuffles the ArrayList to simulate a deck shuffle.
    public void shuffle(){
        Collections.shuffle(deck);
    }


    // Debugging tool.
    public void printDeck() {
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}
