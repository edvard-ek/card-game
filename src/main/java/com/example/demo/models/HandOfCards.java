package com.example.demo.models;

import com.example.demo.models.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public class HandOfCards {

    private final List<PlayingCard> hand;

    public HandOfCards() {
        this.hand = new ArrayList();
    }

    public void addCard(PlayingCard card) {
        hand.add(card);
    }
}
