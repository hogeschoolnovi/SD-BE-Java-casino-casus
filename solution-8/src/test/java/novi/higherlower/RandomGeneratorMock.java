package novi.higherlower;

import novi.randomGenerator.IRandomGenerator;

public class RandomGeneratorMock implements IRandomGenerator {

    @Override
    public int randomInt(int bound) {
        return 50;
    }
}
