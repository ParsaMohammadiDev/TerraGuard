package ir.ac.kntu.services.game.core.difficulties;

public class Easy implements GameDifficulty {
    private static final double EXPONENTIAL_GROWTH = (double) 1 / 8;
    private static final double STEP_SIZE = 0.1;
    private static final double START_LEVEL = 0;
    private static final double END_LEVEL = 3.5;

    private double level = START_LEVEL;
    
    @Override
    public int enumerate() {
        return 0;
    }

    @Override
    public double getDifficultyCoefficient() {
        return Math.pow(Math.E, EXPONENTIAL_GROWTH * level);
    }

    @Override
    public boolean levelUp() {
        level += STEP_SIZE;
        return !(level >= END_LEVEL);
    }

    @Override
    public void reset() {
        level = START_LEVEL;
    }
}