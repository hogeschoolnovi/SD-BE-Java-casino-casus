package novi.randomGenerator;

import java.util.Random;

public class RandomGenerator implements IRandomGenerator {
    public Random generator;

    public RandomGenerator() {
        this.generator = new Random();
    }

    public int randomInt(int bound) {
        return generator.nextInt(bound);
    }
}
