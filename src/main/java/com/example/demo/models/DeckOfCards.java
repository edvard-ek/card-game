package com.example.demo.models;

import java.util.*;

public class DeckOfCards {

    private final List<PlayingCard> deck;

    public DeckOfCards() {
        this.deck = new ArrayList<>();

        char[] suits = {'S', 'H', 'D', 'C'};
        Arrays.stream(suits)
              .forEach(suit ->
                    deck.addAll(
                        java.util.stream.IntStream.rangeClosed(1, 13)
                                                    .mapToObj(face -> new PlayingCard(suit, face))
                                                    .toList()
                    ));
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