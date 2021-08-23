package novi.slotmachines.machines.Penny;

import novi.slotmachines.Symbol;
import novi.slotmachines.machines.SlotMachine;

public class PennyMachine extends SlotMachine {

    public PennyMachine() {
        super("Penny slot machine", 3);
    }

    @Override
    public int getRollPrice() {
        return 1;
    }

    @Override
    protected int calculatePayout() {
        if (this.reelDeck.allReelsHaveSymbol(Symbol.STAR)) {
            return 5;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.YINYANG)) {
            return 5;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.SPADE)) {
            return 5;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.HEART)) {
            return 5;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.CLUB)) {
            return 5;
        }

        return 0;
    }

    @Override
    protected String renderWinningConditions() {
        return "3x star    | 5 tokens\n" + "3x yinyang | 10 tokens\n" + "3x spade   | 15 tokens\n"
                + "3x heart   | 20 tokens\n" + "3x club    | 25 tokens\n";
    }
}
