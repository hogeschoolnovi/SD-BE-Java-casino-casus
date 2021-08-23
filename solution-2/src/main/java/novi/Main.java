package novi;

import java.util.Scanner;

import novi.blackjack.BlackjackGame;

public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        // HigherLowerGame game = new HigherLowerGame(inputScanner);
        BlackjackGame game = new BlackjackGame(inputScanner);

        game.playGame();
    }
}
