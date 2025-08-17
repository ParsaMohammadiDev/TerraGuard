package ir.ac.kntu.services.game.core.difficulties;

public class Easy implements GameDifficulty {
    private static final double EXPONENTIAL_GROWTH = (double) 1 / 4;
    private static final double STEP_SIZE = 0.5;
    private static final double START_LEVEL = 0;

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
    public void levelUp() {
        level += STEP_SIZE;
    }

    @Override
    public void reset() {
        level = START_LEVEL;
    }
}