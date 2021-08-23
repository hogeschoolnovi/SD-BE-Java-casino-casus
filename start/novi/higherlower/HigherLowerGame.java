package novi.higherlower;

import java.util.Scanner;

public class HigherLowerGame {
    private Scanner inputScanner;
    private boolean gameIsRunning;

    public HigherLowerGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public void playGame() {
        gameIsRunning = true;

        // Here you should generate the number to guess

        while (gameIsRunning) {
            System.out.println("Make a guess");

            var input = inputScanner.nextLine();
            System.out.printf("You typed: %s\n", input);

            // Check if the guess is correct, if so end the game
        }
    }
}
