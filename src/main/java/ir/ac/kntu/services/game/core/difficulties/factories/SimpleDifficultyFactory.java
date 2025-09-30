package ir.ac.kntu.services.game.core.difficulties.factories;

import ir.ac.kntu.services.game.core.difficulties.Easy;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;
import ir.ac.kntu.services.game.core.difficulties.Hard;
import ir.ac.kntu.services.game.core.difficulties.Medium;

public class SimpleDifficultyFactory implements DifficultyFactory {
    @Override
    public GameDifficulty getEasyDifficulty() {
        return new Easy();
    }

    @Override
    public GameDifficulty getMediumDifficulty() {
        return new Medium();
    }

    @Override
    public GameDifficulty getHardDifficulty() {
        return new Hard();
    }
}