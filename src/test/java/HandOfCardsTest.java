import com.example.demo.models.HandOfCards;
import com.example.demo.models.PlayingCard;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandOfCardsTest {

    @Test
    void testAddCardAndCheckPoints() {
        HandOfCards hand = new HandOfCards();
        hand.addCard(new PlayingCard('H', 5));
        hand.addCard(new PlayingCard('S', 10));

        assertEquals(15, hand.checkPoints());
    }

    @Test
    void testCheckHearts() {
        HandOfCards hand = new HandOfCards();
        hand.addCard(new PlayingCard('H', 2));
        hand.addCard(new PlayingCard('H', 10));
        hand.addCard(new PlayingCard('D', 5));

        List<PlayingCard> hearts = hand.checkHearts();
        assertEquals(2, hearts.size());
        assertEquals("H2", hearts.get(0).getAsString());
        assertEquals("H10", hearts.get(1).getAsString());
    }

    @Test
    void testCheckQueenOfSpades() {
        HandOfCards hand = new HandOfCards();
        hand.addCard(new PlayingCard('S', 12)); // Queen of Spades

        assertTrue(hand.checkQueenOfSpades());

        hand.addCard(new PlayingCard('H', 12)); // Queen of Hearts
        assertTrue(hand.checkQueenOfSpades());

        hand = new HandOfCards();
        hand.addCard(new PlayingCard('H', 12));
        assertFalse(hand.checkQueenOfSpades());
    }

    @Test
    void testCheckFlush() {
        HandOfCards hand = new HandOfCards();
        hand.addCard(new PlayingCard('H', 2));
        hand.addCard(new PlayingCard('H', 5));
        hand.addCard(new PlayingCard('H', 8));
        hand.addCard(new PlayingCard('H', 10));
        hand.addCard(new PlayingCard('H', 12));

        assertTrue(hand.checkFlush());

        hand.addCard(new PlayingCard('D', 3)); // Ulike farger
        assertFalse(hand.checkFlush());
    }
}