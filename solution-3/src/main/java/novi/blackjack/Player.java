package novi.blackjack;

public class Player {
    public Hand hand;
    private boolean staying;

    public Player() {
        this.hand = new Hand();
    }

    public void performMove(Deck deck, String move) {
        if (move.equals("hit")) {
            this.hand.addCard(deck.getNextCard());
            System.out.println("You hit!\n");
        } else if (move.equals("stay")) {
            this.staying = true;
            System.out.println("You stay!\n");
        }
    }

    public void addCardsToHand(Card... cards) {
        for (Card card : cards) {
            hand.addCard(card);
        }
    }

    public boolean isStaying() {
        return staying;
    }

    public boolean isBust() {
        return hand.getTotalValue() > 21;
    }

    public String renderHand() {
        return hand.render();
    }

    public int getHandValue() {
        return hand.getTotalValue();
    }
}
