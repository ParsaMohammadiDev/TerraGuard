package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.game.core.GameEngine;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;
import ir.ac.kntu.services.game.core.difficulties.factories.DifficultyFactory;

public class SimpleDifficultyManager implements DifficultyManager {
    private final DifficultyFactory difficultyFactory;

    private  GameEngine gameEngine;

    public SimpleDifficultyManager(DifficultyFactory difficultyFactory) {
        this.difficultyFactory = difficultyFactory;
    }

    @Override
    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void levelUp(GameDifficulty currentDifficulty) {
        if (!currentDifficulty.levelUp()) {
            gameEngine.setGameDifficulty(getDifficulty(currentDifficulty.enumerate()));
        }
    }

    @Override
    public void reset() {
        gameEngine.setGameDifficulty(difficultyFactory.getEasyDifficulty());
    }

    private GameDifficulty getDifficulty(int enumeration) {
        return switch (enumeration) {
            case 0 -> difficultyFactory.getMediumDifficulty();
            case 1 -> difficultyFactory.getHardDifficulty();
            default -> throw new IllegalArgumentException("Invalid enumeration");
        };
    }
}