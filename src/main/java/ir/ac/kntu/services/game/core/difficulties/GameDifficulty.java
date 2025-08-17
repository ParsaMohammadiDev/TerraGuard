package ir.ac.kntu.services.game.core.difficulties;

public interface GameDifficulty {
    int enumerate();
    double getDifficultyCoefficient();
    void levelUp();
    void reset();
}