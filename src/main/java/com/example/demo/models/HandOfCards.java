package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

public class HandOfCards {

    private final List<PlayingCard> hand;

    public HandOfCards() {
        this.hand = new ArrayList<>();
    }

    public void addCard(PlayingCard card) {
        hand.add(card);
    }

    public int checkPoints() {
        int sumPoints = 0;
        for (PlayingCard card : hand) {
            sumPoints += card.getFace();
        }
        return sumPoints;
    }

    public ArrayList<PlayingCard> checkHearts() {
        ArrayList<PlayingCard> hearts = new ArrayList<>();
        for (PlayingCard card : hand) {
            if (card.getSuit() == 'H') {
                hearts.add(card);
            }
        }
        return hearts;
    }

    public boolean checkQueenOfSpades() {
        for (PlayingCard card : hand) {
            if (card.getSuit() == 'S' && card.getFace() == 12) {
                return true;
            }
        }
        return false;
    }

    public boolean checkFlush() {
       if (hand.size() < 5) {
           return false;
       }

       char suit = hand.get(0).getSuit();
       for (int i = 1; i < hand.size(); i++) {
           if (hand.get(i).getSuit() != suit) {
               return false;
           }
       }
       return true;
    }
}
