import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void nameIsK(){
        Card card = new Card(Suits.HEARTS.getSuitName(), Ranks.KING.getName(), Ranks.KING.getValue());
        assertEquals("K", card.getName());
    }

    @Test
    void rankIs5(){
        Card card = new Card(Suits.DIAMONDS.getSuitName(), Ranks.FIVE.getName(), Ranks.FIVE.getValue());
        assertEquals(5, card.getRank());
    }

    @Test
    void toStringTest(){
        Card card = new Card(Suits.SPADES.getSuitName(), Ranks.QUEEN.getName(), Ranks.QUEEN.getValue());
        assertEquals("Q of Spades", card.toString());
    }

}