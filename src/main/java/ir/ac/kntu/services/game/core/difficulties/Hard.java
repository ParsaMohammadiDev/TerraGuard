package ir.ac.kntu.services.game.core.difficulties;

public class Hard implements GameDifficulty {
    private static final double EXPONENTIAL_GROWTH = (double) 1 / 4;
    private static final double START_LEVEL = 5.0;
    private static final double STEP = 0.3;

    private double level = START_LEVEL;

    @Override
    public int enumerate() {
        return 2;
    }

    @Override
    public double getDifficultyCoefficient() {
        return Math.pow(Math.E, EXPONENTIAL_GROWTH * level);
    }

    @Override
    public boolean levelUp() {
        level += STEP;
        return true;
    }

    @Override
    public void reset() {
        level = START_LEVEL;
    }

    @Override
    public String toString() {
        return "Hard";
    }
}