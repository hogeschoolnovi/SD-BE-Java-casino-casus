package novi.slotmachines;

import java.util.Scanner;

import novi.slotmachines.machines.Penny.PennyMachine;
import novi.slotmachines.machines.SlotMachine;
import novi.slotmachines.machines.FiveReeler.FiveReeler;
import novi.slotmachines.machines.HighRoller.HighRoller;

public class SlotMachineGame {
    private Scanner inputScanner;
    private SlotMachine[] slotMachines;
    private SlotMachine activeMachine;

    private boolean gameIsRunning;
    private int startCoins;
    private int currentCoins;

    public SlotMachineGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
        slotMachines = new SlotMachine[] { new PennyMachine(), new HighRoller(), new FiveReeler() };
    }

    public void playGame() {
        gameIsRunning = true;
        startCoins = 100;
        currentCoins = startCoins;

        activeMachine = pickMachine(currentCoins);
        activeMachine.renderIntro();
        while (gameIsRunning) {
            runGameLoop();
        }
    }

    private void runGameLoop() {
        if (currentCoins < activeMachine.getRollPrice()) {
            System.out.println("You don't have enough coins to roll");
            gameIsRunning = false;
            return;
        }

        var move = getNextMove();
        if (move.equals("s")) {
            System.out.printf("Thank you for playing! You have %d coins", currentCoins);
            gameIsRunning = false;
        } else {
            this.currentCoins = currentCoins - activeMachine.getRollPrice();
            int winnings = activeMachine.roll();
            this.currentCoins = currentCoins + winnings;
            System.out.println(activeMachine.render());
            System.out.printf("You won %d tokens\n", winnings);
            System.out.printf("You now have %d tokens\n", currentCoins);
        }
    }

    private SlotMachine pickMachine(int coins) {
        while (true) {
            System.out.println("Which machine do you want to play? (0 = Penny Machine, 1 = High Roller, 2 = 5-reeler)");
            int index = inputScanner.nextInt();

            if (index >= 0 && index <= 2) {
                var machine = slotMachines[index];
                if (machine.getRollPrice() <= coins) {
                    return machine;
                } else {
                    System.out.printf(
                            "You don't have enough coins to roll on this machine, you need %d and you have %d\n",
                            machine.getRollPrice(), coins);
                }
            }
        }
    }

    private String getNextMove() {
        while (true) {
            System.out.println("Hit r to roll or s to stop playing");

            if (inputScanner.hasNext()) {
                String move = inputScanner.nextLine();
                if (move.equals("r") || move.equals("s")) {
                    return move;
                }
            }
        }
    }
}
