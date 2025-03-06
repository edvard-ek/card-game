package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class HandOfCards {

    private final List<PlayingCard> hand;

    public HandOfCards() {
        this.hand = new ArrayList<>();
    }

    public void addCard(PlayingCard card) {
        hand.add(card);
    }

    public int checkPoints() {
        return hand.stream()
                    .mapToInt(PlayingCard::getFace)
                    .sum();
    }

    public List<PlayingCard> checkHearts() {
        return hand.stream()
                    .filter(card -> card.getSuit() == 'H')
                    .collect(Collectors.toList());
    }

    public boolean checkQueenOfSpades() {
        return hand.stream()
                    .anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
    }

    public boolean checkFlush() {
        return hand.size() >= 5 && hand.stream()
                                        .map(PlayingCard::getSuit)
                                        .distinct()
                                        .count() == 1;
    }
}
