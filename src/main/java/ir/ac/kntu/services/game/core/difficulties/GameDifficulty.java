package ir.ac.kntu.services.game.core.difficulties;

public interface GameDifficulty {
    int enumerate();
    double getDifficultyCoefficient();
    boolean levelUp();
    void reset();
}