package main.java.com.example.demo;

public class DeckOfCards {

    private final Set<> deck;

    public DeckOfCards() {
        this.deck = new HashSet<>();

        char[] suits = {'S', 'H', 'D', 'C'};
        for (char suit : suits) {
            for (int face = 1; face <= 13; face++) {
                deck.add(new PlayingCard(suit, face));
            }
        }
    }

    public Set<PlayingCard> getDeck() {
        return deck;
    }
}