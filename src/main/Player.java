import java.util.ArrayList;

public class Player {
    private Deck deck;
    private ArrayList<Card> hand;
    private boolean isBlackJack; // true if player has BlackJack, else false.
    private boolean isBust; // true if the player's score is above 21, else false.
    private int score; // Hand score.
    private final String name;

    public Player(Deck d, String n){
        hand = new ArrayList<>();
        deck = d;
        isBlackJack = false;
        isBust = false;
        score = 0;
        name = n;
    }

    public int getScore() { return score; }

    public boolean isBlackJack() { return isBlackJack; }

    public boolean isBust() { return isBust; }

    // Resets the game state in case the player wants to play another hand.
    public void reset(){
        hand.clear();
        score = 0;
        isBlackJack = false;
        isBust = false;
    }

    // Deals 2 cards to each player.
    public void dealHand(){
        for (int i=0; i<2; i++){
            Card card = deck.getDeck().get(0); // Getting the top card from the deck.
            hand.add(card); // Adding card to hand.
            deck.getDeck().remove(card); // Remove card from deck.
       }
        handScore(); //Checking the hand score after initial deal to check for BlackJack.
        if (score==21)
            isBlackJack = true;
    }

    // Prints the player's hand and hand score.
    public void showHand(){
        System.out.print(name+ "'s Hand: ");
        for (Card card: hand){
            System.out.print("|" + card + "|  ");
        }
        System.out.print("Hand Score: " + score);
        System.out.println();
    }

    // Prints dealer's first hand after initial dealing. the first card is hidden from the player.
    public void showDealerHand(){
        System.out.println(name + "'s Hand: |BLANK|\t|" + hand.get(1) + "|" );
    }

    // Gives the player another card. if score exceeds 21, player lost.
    public void hit(){
        System.out.println(name + " Hits!");
        Card card = deck.getDeck().get(0);
        hand.add(card);
        deck.getDeck().remove(card);

        handScore();
        if (score > 21)
            isBust = true;
    }

    // Calculates the hand score.
    public void handScore(){
        score = 0;
        int aceCounter = 0; // Keeps track of amount of aces in hand.
        if (!hand.isEmpty()){
            for (Card card: hand){
                if (card.getName().equals("1"))
                    aceCounter++;
                score+=card.getRank();

            }
        }

        /*
        Aces are worth 11 until the score exceeds 21.
        if there are aces in hand and the score > 21, removes 10 points from the score for each ace until score < 21
        or no more aces in hand.
        Could be its own function.
        */
        while (aceCounter != 0 && score > 21){
            aceCounter -= 1;
            score -= 10;
        }

        // If score > 21, isBust = true, else false.
        isBust = score > 21;
    }
}
