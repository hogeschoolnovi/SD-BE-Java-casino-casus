package novi.slotmachines.machines.FiveReeler;

import novi.slotmachines.Symbol;
import novi.slotmachines.machines.SlotMachine;

public class FiveReeler extends SlotMachine {

    public FiveReeler() {
        super("Five reeler machine", 5);
    }

    @Override
    public int getRollPrice() {
        return 5;
    }

    @Override
    protected int calculatePayout() {
        if (this.reelDeck.allReelsHaveSymbol(Symbol.STAR)) {
            return 50;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.YINYANG)) {
            return 100;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.SPADE)) {
            return 150;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.HEART)) {
            return 200;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.CLUB)) {
            return 250;
        }

        return 0;
    }

    @Override
    protected String renderWinningConditions() {
        return "3x star    | 50 tokens\n" + "3x yinyang | 100 tokens\n" + "3x spade   | 150 tokens\n"
                + "3x heart   | 200 tokens\n" + "3x club    | 250 tokens\n";
    }
}
