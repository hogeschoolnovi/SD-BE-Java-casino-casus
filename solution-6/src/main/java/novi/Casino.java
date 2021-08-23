package novi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import novi.blackjack.LowDeckBlackjack;
import novi.blackjack.SimpleBlackjack;
import novi.hangman.HangmanGame;
import novi.higherlower.HigherLowerGame;
import novi.slotmachines.SlotMachineGame;

public class Casino {
    private final Scanner inputScanner;
    private final List<Game> games;
    private int coins;

    public Casino(Scanner inputScanner) {
        this.inputScanner = inputScanner;
        this.games = new ArrayList<>();
        this.games.add(new HigherLowerGame(inputScanner));
        this.games.add(new LowDeckBlackjack(inputScanner));
        this.games.add(new SimpleBlackjack(inputScanner));
        this.games.add(new SlotMachineGame(inputScanner));
        this.games.add(new HangmanGame(inputScanner));

        this.coins = 1000;
    }

    public void start() {
        System.out.printf("\n$$$ Welcome to the Golden Triangle casino! $$$\n");

        while (true) {
            System.out.println("Press p to start a game or q to quit");
            String input = inputScanner.next();

            if (input.equals("p")) {
                playAGame();
            } else if (input.equals("q")) {
                System.out.printf("Thank you for playing, you ended with %d coins", coins);
                inputScanner.close();
                System.exit(0);
            }
        }
    }

    private void playAGame() {
        System.out.printf("You have %d coins which allows you to play the following games.\n", coins);

        var playableGames = getPlayableGames();
        for (int i = 0; i < playableGames.size(); i++) {
            System.out.printf("%d. %s\n", i, playableGames.get(i).getName());
        }

        var currentGame = getGameToPlay(playableGames);

        currentGame.playGame(coins);

        var coinResult = currentGame.getWinnings();
        processWinnings(coinResult);
    }

    private List<Game> getPlayableGames() {
        List<Game> filteredGames = new ArrayList<>();

        for (Game game : games) {
            if (game.getMinimalRequiredCoins() <= this.coins) {
                filteredGames.add(game);
            }
        }

        return filteredGames;
    }

    private Game getGameToPlay(List<Game> playableGames) {
        while (true) {
            System.out.printf("Which game do you want to play? (0 - %d)\n", playableGames.size() - 1);

            if (inputScanner.hasNextInt()) {
                int index = inputScanner.nextInt();
                if (index >= 0 && index < playableGames.size()) {
                    return playableGames.get(index);
                }
            }
        }
    }

    private void processWinnings(int winnings) {
        this.coins = this.coins + winnings;

        if (winnings >= 0) {
            System.out.printf("You won %d coins\n", winnings);
        } else {
            System.out.printf("You lost %d coins\n", -winnings);
        }
        System.out.printf("You now have %d coins\n", coins);
    }
}
