package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.app.scenes.managers.SceneManager;
import ir.ac.kntu.services.game.core.GameEngine;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;
import ir.ac.kntu.services.game.core.difficulties.factories.DifficultyFactory;
import ir.ac.kntu.services.game.core.difficulties.publishers.LevelPublisher;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class SimpleDifficultyManager implements DifficultyManager {
    private static final Duration LEVEL_UP_WAIT_TIME = Duration.seconds(3);

    private final DifficultyFactory difficultyFactory;
    private final LevelPublisher levelPublisher;
    private final SceneManager sceneManager;
    private int level;

    private GameEngine gameEngine;

    public SimpleDifficultyManager(DifficultyFactory difficultyFactory, LevelPublisher levelPublisher, SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        this.difficultyFactory = difficultyFactory;
        this.levelPublisher = levelPublisher;
    }

    @Override
    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        level = 1;
        levelPublisher.notifySubscribers(gameEngine.getGameDifficulty());
        levelPublisher.notifySubscribers(level);
    }

    @Override
    public void levelUp(GameDifficulty currentDifficulty) {
        levelPublisher.notifySubscribers(++ level);
        if (!currentDifficulty.levelUp()) {
            gameEngine.setGameDifficulty(getDifficulty(currentDifficulty.enumerate()));
            levelPublisher.notifySubscribers(gameEngine.getGameDifficulty());
            sceneManager.showLevelUp();
        } else {
            PauseTransition pause = new PauseTransition(LEVEL_UP_WAIT_TIME);
            pause.setOnFinished(event -> {gameEngine.resume();});
            pause.play();
        }
    }

    @Override
    public void reset() {
        level = 1;
        levelPublisher.notifySubscribers(level);
        gameEngine.setGameDifficulty(difficultyFactory.getEasyDifficulty());
        levelPublisher.notifySubscribers(gameEngine.getGameDifficulty());
    }

    private GameDifficulty getDifficulty(int enumeration) {
        return switch (enumeration) {
            case 0 -> difficultyFactory.getMediumDifficulty();
            case 1 -> difficultyFactory.getHardDifficulty();
            default -> throw new IllegalArgumentException("Invalid enumeration");
        };
    }
}