package novi;

import java.util.Scanner;

import novi.higherlower.HigherLowerGame;

public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        HigherLowerGame game = new HigherLowerGame(inputScanner);

        game.playGame();
    }
}
