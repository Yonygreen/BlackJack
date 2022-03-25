public enum Suits {
    CLUBS("Clubs"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    SPADES("Spades");

    private final String suitName;

    Suits(String suit){
        suitName = suit;
    }

    public String getSuitName(){
        return suitName;
    }
}
