package novi.blackjack;

import java.util.Scanner;

public class LowDeckBlackjack extends BlackjackGame {


    public LowDeckBlackjack(Scanner inputScanner) {
        super(inputScanner, new LowDeck());
    }

    public void runGameLoop() {
        renderTableState();

        if (player.isBust() || player.isStaying() && player.getHandValue() <= dealer.getHandValue()) {
            System.out.println("You lost!");
            gameIsRunning = false;
            gameIsWon = false;
            return;
        }

        if (dealer.isBust() || dealer.isStaying() && player.getHandValue() > dealer.getHandValue()) {
            System.out.println("You won!");
            gameIsRunning = false;
            gameIsWon = true;
            return;
        }

        if (!player.isStaying()) {
            String move = getNextUserMove();
            player.performMove(deck, move);
        }

        if (!dealer.isStaying() && !player.isBust()) {
            dealer.performMove(deck);
        }
    }

    private String getNextUserMove() {
        while (true) {
            System.out.println("What do you want to do? (hit or stay)");
            String input = inputScanner.nextLine();

            if (input.equals("hit") || input.equals("stay")) {
                return input;
            }
        }
    }

    private void renderTableState() {
        System.out.println("");
        System.out.println("Dealers hand:");
        System.out.println(dealer.renderHand());
        System.out.println("");

        System.out.println("your hand:");
        System.out.println(player.renderHand());
        System.out.println("");
    }

    @Override
    public void renderRules() {
        super.renderRules();
        System.out.println("	- In this variant of Blackjack only low cards are used!\n\n");
    }

    @Override
    public String getName() {
        return "Low Deck BlackJack";
    }
}
