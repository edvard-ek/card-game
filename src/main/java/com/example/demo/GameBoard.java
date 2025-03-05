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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameBoard extends Application {

    private DeckOfCards deck;
    private HandOfCards hand;
    private Label messageLabel;
    private ListView<String> handView;
    private Label hearts;
    private Label sumFaces;
    private Label flush;
    private Label spadeQueen;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        deck = new DeckOfCards();
        hand = new HandOfCards();
        messageLabel = new Label("Press 'Deal hand' to draw cards!");
        handView = new ListView<>();
        handView.setPrefSize(300, 150);

        Button dealButton = new Button("Deal hand");
        dealButton.setOnAction(e -> dealHand());

        Button checkHandButton = new Button("Check hand");
        checkHandButton.setOnAction(e -> checkHand());

        sumFaces = new Label("Sum of faces: 0");
        hearts = new Label("Cards of heart: 0");
        flush = new Label("Flush: Yes/No");
        spadeQueen = new Label("Queen of spades: Yes/No");
        HBox checks = new HBox(10, sumFaces, hearts, flush, spadeQueen);

        VBox layout = new VBox(10, messageLabel, dealButton, checkHandButton, handView, checks);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(layout, 800, 500);
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

    private void updateHandValues() {
        StringBuilder heartsAsString = new StringBuilder();
        for (PlayingCard card : hand.checkHearts()) {
            heartsAsString.append(card.getAsString()).append(" ");
        }
        if (hand.checkFlush()) {
            flush.setText("Flush: Yes");
        }
        if (hand.checkQueenOfSpades()) {
            spadeQueen.setText("Queen of spades: Yes");
        }
        spadeQueen.setText("Queen of spades: No");
        flush.setText("Flush: No");
        hearts.setText("Cards of heart: " + heartsAsString);
        sumFaces.setText("Sum of faces: " + hand.checkPoints());
    }

    private void checkHand() {
    updateHandValues();
    }
}