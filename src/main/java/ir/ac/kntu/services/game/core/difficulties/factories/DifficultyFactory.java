package ir.ac.kntu.services.game.core.difficulties.factories;

import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;

public interface DifficultyFactory {
    GameDifficulty getEasyDifficulty();
    GameDifficulty getMediumDifficulty();
    GameDifficulty getHardDifficulty();
}