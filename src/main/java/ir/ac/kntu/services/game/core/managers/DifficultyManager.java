package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.game.core.GameEngine;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;

public interface DifficultyManager {
    void levelUp(GameDifficulty currentDifficulty);
    void reset();
    void setGameEngine(GameEngine gameEngine);
}