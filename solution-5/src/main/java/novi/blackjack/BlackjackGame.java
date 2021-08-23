package novi.blackjack;

import java.util.Scanner;

public abstract class BlackjackGame {
    protected Scanner inputScanner;

    protected boolean gameIsRunning;
    protected boolean gameIsWon;

    protected Deck deck;
    protected Player player;
    protected Dealer dealer;

    public BlackjackGame(Scanner inputScanner, Deck deck) {
        this.inputScanner = inputScanner;
        this.deck = deck;
    }

    public void playGame() {
        gameIsRunning = true;

        player = new Player();
        dealer = new Dealer();

        deck.shuffle();
        dealer.addCardsToHand(deck.getNextCard());
        player.addCardsToHand(deck.getNextCard(), deck.getNextCard());

        while (gameIsRunning) {
            runGameLoop();
        }
    }

    abstract void runGameLoop();
}