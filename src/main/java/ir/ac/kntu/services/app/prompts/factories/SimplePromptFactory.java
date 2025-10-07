package ir.ac.kntu.services.app.prompts.factories;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.prompts.ExitPrompt;
import ir.ac.kntu.services.app.prompts.PausePrompt;
import ir.ac.kntu.services.app.prompts.Prompt;
import ir.ac.kntu.services.app.scenes.managers.SceneManager;
import ir.ac.kntu.services.game.core.GameEngine;
import javafx.stage.Stage;

public class SimplePromptFactory implements PromptFactory {
    private final AnimationFactory animFactory;
    private final Stage stage;

    private GameEngine gameEngine;
    private SceneManager sceneManager;

    public SimplePromptFactory(AnimationFactory animationFactory, Stage stage) {
        this.animFactory = animationFactory;
        this.stage = stage;
    }

    @Override
    public Prompt getExitPrompt() {
        return new ExitPrompt(gameEngine, animFactory, stage);
    }

    @Override
    public Prompt getPausePrompt() {
        return new PausePrompt(gameEngine, animFactory, sceneManager, stage);
    }

    @Override
    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }
}
