public class Card {
    private final String suit; // Hearts, Diamonds etc...
    private final String name; // 2,3,J,K etc...
    private final int rank; // 8,9,10 etc..

    public Card(String s, String n, int r){
        suit = s;
        name = n;
        rank = r;
    }

    public String getName() { return name; }

    public int getRank() { return rank; }

    public String toString(){ // Prints a description of the card. ex: 5 of Spades
        String str = "";
        str+=name + " of " + suit;
        return str;
    }
}

