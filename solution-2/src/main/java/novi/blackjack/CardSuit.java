package novi.blackjack;

public class CardSuit {
    private String name;
    private char symbol;
    private String color;

    public CardSuit(String name, char symbol, String color) {
        this.name = name;
        this.symbol = symbol;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }
}
