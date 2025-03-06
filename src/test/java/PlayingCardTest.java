import com.example.demo.models.PlayingCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayingCardTest {

    @Test
    void testValidCardCreation() {
        PlayingCard card = new PlayingCard('H', 10);
        assertEquals('H', card.getSuit());
        assertEquals(10, card.getFace());
    }

    @Test
    void testInvalidSuitThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new PlayingCard('X', 10));
        assertEquals("Parameter suit must be one of H, D, C or S", exception.getMessage());
    }

    @Test
    void testInvalidFaceThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new PlayingCard('H', 14));
        assertEquals("Parameter face must be a number between 1 to 13", exception.getMessage());
    }

    @Test
    void testGetAsString() {
        PlayingCard card = new PlayingCard('S', 12);
        assertEquals("S12", card.getAsString());
    }

    @Test
    void testEqualsAndHashCode() {
        PlayingCard card1 = new PlayingCard('D', 7);
        PlayingCard card2 = new PlayingCard('D', 7);
        PlayingCard card3 = new PlayingCard('H', 7);

        assertEquals(card1, card2);
        assertNotEquals(card1, card3);
        assertEquals(card1.hashCode(), card2.hashCode());
    }
}