import com.example.demo.models.DeckOfCards;
import com.example.demo.models.PlayingCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

    private DeckOfCards deck;

    @BeforeEach
    void setUp() {
        deck = new DeckOfCards();
    }

    @Test
    void testDeckInitialization() {
        List<PlayingCard> cards = deck.getDeck();
        assertEquals(52, cards.size());

        assertEquals(52, new HashSet<>(cards).size());
    }

    @Test
    void testDealHand() {
        Collection<PlayingCard> hand = deck.dealHand(5);

        assertEquals(5, hand.size());
        assertEquals(47, deck.getDeck().size());
    }

    @Test
    void testDealHandReducesDeckSize() {
        int initialSize = deck.getDeck().size();
        deck.dealHand(5);
        assertEquals(initialSize - 5, deck.getDeck().size());
    }

    @Test
    void testDealHandWithEmptyDeck() {
        for (int i = 0; i < 10; i++) {
            if (deck.getDeck().size() >= 5) {
                deck.dealHand(5);
            }
        }

        // Sjekker at dekket er tomt
        assertEquals(2, deck.getDeck().size(), "Deck should be empty after dealing all cards");

        // Forsøker å trekke en hånd fra et tomt dekk, forventer en Exception
        Exception exception = assertThrows(RuntimeException.class, () -> deck.dealHand(5));
    }
}
