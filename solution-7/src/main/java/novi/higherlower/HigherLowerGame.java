package novi.higherlower;

import java.util.Random;
import java.util.Scanner;

import novi.Game;

public class HigherLowerGame implements Game {
    private Scanner inputScanner;

    private boolean gameIsRunning;

    private int numberToGuess;
    private int numberOfTurns;

    public HigherLowerGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    @Override
    public String getName() {
        return "Higher Lower";
    }

    @Override
    public int getMinimalRequiredCoins() {
        return 5;
    }

    public void playGame(int coins) {
        gameIsRunning = true;
        numberToGuess = new Random().nextInt(100);
        numberOfTurns = 0;

        printRules();
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

    private int calculateWinnings() {
        if (numberOfTurns <= 3) {
            return 20;
        } else if (numberOfTurns <= 6) {
            return 10;
        } else if (numberOfTurns <= 9) {
            return 5;
        }
        return 0;
    }

    private void printRules() {
        System.out.println("Welcome to Higher Lower!\n\n");
        System.out.println(" RULES: ");
        System.out.println("	- Each game costs 5 tokens");
        System.out.println("	- Your goal is to guess a number between 0 - 100 as quickly as possible");
        System.out.println("	- when you guess the number within 3 turns you win 20 tokens");
        System.out.println("	- when you guess the number within 6 turns you win 10 tokens");
        System.out.println("	- when you guess the number within 9 turns you win 5 tokens");
        System.out.println("	- when you guess the number in more than 9 turns you loose");
    }

    @Override
    public int getWinnings() {
        return calculateWinnings() - 5;
    }
}
