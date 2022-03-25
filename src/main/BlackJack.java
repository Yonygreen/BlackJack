import java.util.Scanner;

public class BlackJack {
    private final Player player;
    private final Player dealer;
    private Deck deck;

    public BlackJack(){
        deck = new Deck();
        deck.shuffle();
        player = new Player(deck, "Player");
        dealer = new Player(deck, "Dealer");
    }

    public void gameLoop(){
        // Dealing hands for player and dealer.
        player.dealHand();
        dealer.dealHand();

        player.showHand();
        dealer.showDealerHand(); // Showing dealer first hand which obscures the first card in his hand/

        // Checking player's and dealer's hand score.
        player.handScore();
        dealer.handScore();

        if (player.isBlackJack()){
            System.out.println("Player got BlackJack!");
            if (dealer.isBlackJack())
                System.out.println("Dealer also got BlackJack! It's a tie!");
            keepPlaying(); // Player wins or tie, sends to replay prompt.
        }

        Scanner scanner = new Scanner(System.in);
        String userInput ="";
        while (!userInput.equals("s")){

            // For debugging
            if (userInput.equals("size")){
                System.out.println("Deck Size: " + deck.getDeckSize());
            }

            if (userInput.equals("h")) {
                player.hit();
                player.showHand();
            }

            // Checking if player's score > 25.
            if (player.isBust()) {
                System.out.println("BUST! YOU LOSE!");
                keepPlaying();
            }
            System.out.println("Hit or Stand? (h/s)"); // Prompts the user to Hit or Stand.
            userInput = scanner.nextLine();
        }

        dealer.showHand(); //Showing full dealer hand.

        // If dealer has BlackJack he wins, even if player's hand score is 21 after hitting.
        if (dealer.isBlackJack()){
            System.out.println("DEALER HAS BLACKJACK! BETTER LUCK NEXT TIME!");
            keepPlaying();
        }

        while (dealer.getScore() < 17){ // Dealer hits until his hand score >= 17.
            dealer.hit();
            dealer.showHand();
            if (dealer.isBust()){
                System.out.println("Dealer Busted! Loser!");
                keepPlaying();
            }
        }

        System.out.println(); // Spacing.

        // Showing final hands before checking who won.
        player.showHand();
        dealer.showHand();

        // Checking for winner. Could be its own function.
        if (dealer.getScore()==player.getScore())
            System.out.println("IT'S A TIE!");
        else if (dealer.getScore() > player.getScore())
            System.out.println("Dealer Wins!");
        else
            System.out.println("Player Wins!");

        keepPlaying();

    }

    public void keepPlaying(){

        /*
        Can't play another hand if the deck running out.
        Keeps the game from Crashing because of index errors when deck runs out.
        Could be improved to allow the deck to reset when running out.
        */
        if (deck.getDeckSize() < 10){
            System.out.println("Deck running out! restart the game!");
            System.exit(0);
        }

        // Plays another hand or terminates the program depending on user input.
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while (!userInput.equals("n")) {
            if (userInput.equals("y")) {
                // Resets player's and dealer's game state.
                player.reset();
                dealer.reset();
                // Returns to the game for another hand.
                gameLoop();
            }
            System.out.println("Play another hand? (y/n)");
            userInput = scanner.nextLine();
        }
        System.exit(0);
    }
}
