package novi.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    public List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public int getTotalValue() {
        int value = 0;

        for (Card card : cards) {
            value += card.getValue();
        }

        return value;
    }

    public String render() {
        String renderedHand = "";
        for (Card card : cards) {
            renderedHand = renderedHand + " " + card.render();
        }
        return renderedHand;
    }
}
