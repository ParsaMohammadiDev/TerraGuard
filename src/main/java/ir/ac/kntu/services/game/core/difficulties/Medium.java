package ir.ac.kntu.services.game.core.difficulties;

public class Medium implements GameDifficulty {
    private static final double EXPONENTIAL_GROWTH = (double) 1 / 4;
    private static final double START_LEVEL = 3.3;
    private static final double STEP = 0.4;

    private double level = START_LEVEL;

    @Override
    public int enumerate() {
        return 1;
    }

    @Override
    public double getDifficultyCoefficient() {
        return Math.pow(Math.E, EXPONENTIAL_GROWTH * level);
    }

    @Override
    public void levelUp() {
        level += STEP;
    }

    @Override
    public void reset() {
        level = START_LEVEL;
    }
}