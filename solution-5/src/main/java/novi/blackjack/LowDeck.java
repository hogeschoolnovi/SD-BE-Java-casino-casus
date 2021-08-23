package novi.blackjack;

public class LowDeck extends Deck {

    public LowDeck() {
        super(new CardSuit[] { new CardSuit("diamonds", '\u2666', "red"), new CardSuit("spades", '\u2660', "black"),
                new CardSuit("hearts", '\u2665', "red"), new CardSuit("clubs", '\u2663', "black") },
                new CardValue[] { new CardValue("two", 2), new CardValue("three", 3), new CardValue("four", 4),
                        new CardValue("five", 5), new CardValue("six", 6) },
                3);
    }
}
