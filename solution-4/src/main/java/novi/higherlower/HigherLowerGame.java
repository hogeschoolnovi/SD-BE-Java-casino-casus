package novi.higherlower;

import java.util.Random;
import java.util.Scanner;

public class HigherLowerGame {
    private Scanner inputScanner;

    private boolean gameIsRunning;

    private int numberToGuess;
    private int numberOfTurns;

    public HigherLowerGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public void playGame() {
        gameIsRunning = true;
        numberToGuess = new Random().nextInt(100);
        numberOfTurns = 0;

        while (gameIsRunning) {
            System.out.println("Make a guess");

            var val = inputScanner.nextInt();
            performGuess(val);
        }
    }

    private void performGuess(int guess) {
        numberOfTurns++;

        if (guess == numberToGuess) {
            gameIsRunning = false;
            System.out.printf("Correct! you guessed the number in %d turns\n", numberOfTurns);
        } else if (guess > numberToGuess) {
            System.out.println("That number is too high");
        } else {
            System.out.println("That number is too low");
        }
    }
}
