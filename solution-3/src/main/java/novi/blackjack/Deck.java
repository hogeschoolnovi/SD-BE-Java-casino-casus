package novi.blackjack;

import java.util.Random;
import java.util.Stack;

public abstract class Deck {
    protected Stack<Card> cards;

    public Deck(CardSuit[] suits, CardValue[] values, int numberOfDecks) {
        cards = new Stack<>();
        for (int i = 0; i < numberOfDecks; i++) {
            for (CardSuit suite : suits) {
                for (CardValue value : values) {
                    cards.add(new Card(suite, value));
                }
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int j = 0; j < cards.size(); j++) {
            int shuffleIndex = random.nextInt(cards.size());
            Card hold = cards.get(j);
            cards.set(j, cards.get(shuffleIndex));
            cards.set(shuffleIndex, hold);
        }
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Card getNextCard() {
        return cards.pop();
    }
}
