package ir.ac.kntu.services.game.core.difficulties;

public class Medium implements GameDifficulty {
    private static final double EXPONENTIAL_GROWTH = (double) 1 / 4;
    private static final double START_LEVEL = 3.5;
    private static final double STEP = 0.2;
    private static final double END_LEVEL = 5.0;

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
    public boolean levelUp() {
        level += STEP;
        return !(level >= END_LEVEL);
    }

    @Override
    public void reset() {
        level = START_LEVEL;
    }

    @Override
    public String toString() {
        return "Medium";
    }
}