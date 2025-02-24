package main.java.com.example.demo;

import java.util.HashSet;
import java.util.Random;

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

    public Collection<PlayingCard> dealHand(int numberOfCards) {
        Random random = new Random();
        Set<PlayingCard> hand = new HashSet<>();
        
        while (hand.size() < numberOfCards) {
            int index = random.nextInt(deck.size());
            hand.add(deck.remove(index));
        }
        return hand;
    }

    public Set<PlayingCard> getDeck() {
        return deck;
    }
}