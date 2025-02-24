package com.example.demo;

import java.util.*;

public class DeckOfCards {

    private final List<PlayingCard> deck;

    public DeckOfCards() {
        this.deck = new ArrayList<>();

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

    public List<PlayingCard> getDeck() {
        return deck;
    }
}