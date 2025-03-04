package com.example.demo;

import java.util.Collection;

import com.example.demo.models.DeckOfCards;
import com.example.demo.models.HandOfCards;
import com.example.demo.models.PlayingCard;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameBoard extends Application {

    private DeckOfCards deck;
    private HandOfCards hand;
    private Label messageLabel;
    private ListView<String> handView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        deck = new DeckOfCards();
        hand = new HandOfCards();
        messageLabel = new Label("Press 'Deal hand' to draw cards!");
        handView = new ListView<>(); // Opprett ListView

        Button dealButton = new Button("Deal hand");
        dealButton.setOnAction(e -> dealHand());

        VBox layout = new VBox(10, messageLabel, dealButton, handView);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("Card Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void dealHand() {
        if (deck.getDeck().size() < 5) {
            messageLabel.setText("Deck is empty!");
            return;
        }

        Collection<PlayingCard> dealtCards = deck.dealHand(5);
        hand = new HandOfCards();
        handView.getItems().clear();

        for (PlayingCard card : dealtCards) {
            hand.addCard(card);
            handView.getItems().add(card.getAsString());
        }

        messageLabel.setText("Your hand has been dealt!");
    }
}