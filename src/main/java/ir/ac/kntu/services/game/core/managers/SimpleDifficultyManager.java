package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.game.core.GameEngine;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;
import ir.ac.kntu.services.game.core.difficulties.factories.DifficultyFactory;
import ir.ac.kntu.services.game.core.difficulties.publishers.LevelPublisher;

public class SimpleDifficultyManager implements DifficultyManager {
    private final DifficultyFactory difficultyFactory;
    private final LevelPublisher levelPublisher;
    private int level;

    private  GameEngine gameEngine;

    public SimpleDifficultyManager(DifficultyFactory difficultyFactory, LevelPublisher levelPublisher) {
        this.difficultyFactory = difficultyFactory;
        this.levelPublisher = levelPublisher;
        level = 1;
        levelPublisher.notifySubscribers(level);
    }

    @Override
    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void levelUp(GameDifficulty currentDifficulty) {
        levelPublisher.notifySubscribers(++ level);
        if (!currentDifficulty.levelUp()) {
            gameEngine.setGameDifficulty(getDifficulty(currentDifficulty.enumerate()));
        }
    }

    @Override
    public void reset() {
        level = 1;
        levelPublisher.notifySubscribers(level);
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