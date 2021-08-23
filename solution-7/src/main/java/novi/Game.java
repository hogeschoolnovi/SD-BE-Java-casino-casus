package novi;

public interface Game {
    public String getName();

    public void playGame(int coins);

    public int getMinimalRequiredCoins();

    public int getWinnings();
}
