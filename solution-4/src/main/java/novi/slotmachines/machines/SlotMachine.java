package novi.slotmachines.machines;

import java.util.ArrayList;

public abstract class SlotMachine {
    private String name;
    protected ReelDeck reelDeck;

    public SlotMachine(String name, int numberOfReels) {
        this.name = name;

        var reels = new ArrayList<Reel>();
        for (int i = 0; i < numberOfReels; i++) {
            reels.add(new Reel());
        }
        this.reelDeck = new ReelDeck(reels);
    }

    public void renderIntro() {
        System.out.println("$--$--$__| LET'S PLAY |__$--$--$");
        System.out.println(name);
        System.out.println("$--$--$__|____________|__$--$--$\n\n");

        System.out.println("WINNING CONDITIONS\n");
        System.out.println(renderWinningConditions());
    }

    public int roll() {
        reelDeck.roll();
        return calculatePayout();
    }

    public String render() {
        return reelDeck.render();
    }

    public abstract int getRollPrice();

    protected abstract int calculatePayout();

    protected abstract String renderWinningConditions();
}
