package novi;

import java.util.Scanner;

import novi.hangman.HangmanGame;

public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        // HigherLowerGame game = new HigherLowerGame(inputScanner);
        // BlackjackGame game = new LowDeckBlackjack(inputScanner);
        // SlotMachineGame game = new SlotMachineGame(inputScanner);
        HangmanGame game = new HangmanGame(inputScanner);

        game.playGame();
    }
}
