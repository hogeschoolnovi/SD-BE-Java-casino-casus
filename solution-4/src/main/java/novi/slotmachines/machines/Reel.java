package novi.slotmachines.machines;

import java.util.Random;

import novi.slotmachines.Symbol;

public class Reel {
    private Symbol currentValue;
    private Symbol[] possibleValues;

    public Reel() {
        this.possibleValues = Symbol.values();
    }

    public void roll() {
        Random random = new Random();
        int index = random.nextInt(possibleValues.length);
        this.currentValue = possibleValues[index];
    }

    public String render() {
        return String.format("[ %s ]", currentValue.icon);
    }

    public Symbol getSymbol() {
        return this.currentValue;
    }
}
