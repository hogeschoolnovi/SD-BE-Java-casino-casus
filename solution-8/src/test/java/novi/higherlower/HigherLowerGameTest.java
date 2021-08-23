package novi.higherlower;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HigherLowerGameTest {
    private HigherLowerGame game;

    @Test
    public void getNameShouldReturnHigherLower() {
        Scanner scanner = new Scanner(System.in);
        game = new HigherLowerGame(scanner, new RandomGeneratorMock());

        assertEquals("Higher Lower", game.getName());
    }

    @Test
    public void getMinimalRequiredCoinsShouldReturn5() {
        Scanner scanner = new Scanner(System.in);
        game = new HigherLowerGame(scanner, new RandomGeneratorMock());

        assertEquals(5, game.getMinimalRequiredCoins());
    }

    @Test
    public void winningTheGameIn3MovesShouldAwardThePlayer15Coins() {
        System.setIn(new ByteArrayInputStream("4\n5\n50\n".getBytes()));
        Scanner scanner = new Scanner(System.in);
        game = new HigherLowerGame(scanner, new RandomGeneratorMock());

        game.playGame(100);
        var winnings = game.getWinnings();

        assertEquals(15, winnings);
    }

    @Test
    public void winningTheGameIn6MovesShouldAwardThePlayer5Coins() {
        System.setIn(new ByteArrayInputStream("0\n0\n0\n0\n0\n50\n".getBytes()));
        Scanner scanner = new Scanner(System.in);
        game = new HigherLowerGame(scanner, new RandomGeneratorMock());

        game.playGame(100);
        var winnings = game.getWinnings();

        assertEquals(5, winnings);
    }

    @Test
    public void winningTheGameIn9MovesShouldAwardThePlayer0Coins() {
        System.setIn(new ByteArrayInputStream("0\n0\n0\n0\n0\n0\n0\n0\n50\n".getBytes()));
        Scanner scanner = new Scanner(System.in);
        game = new HigherLowerGame(scanner, new RandomGeneratorMock());

        game.playGame(100);
        var winnings = game.getWinnings();

        assertEquals(0, winnings);
    }

    @Test
    public void winningTheGameIn10MovesShouldCostThePlayer5Coins() {
        System.setIn(new ByteArrayInputStream("0\n0\n0\n0\n0\n0\n0\n0\n0\n50\n".getBytes()));
        Scanner scanner = new Scanner(System.in);
        game = new HigherLowerGame(scanner, new RandomGeneratorMock());

        game.playGame(100);
        var winnings = game.getWinnings();

        assertEquals(-5, winnings);
    }
}
