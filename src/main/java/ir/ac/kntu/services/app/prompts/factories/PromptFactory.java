package ir.ac.kntu.services.app.prompts.factories;

import ir.ac.kntu.services.app.prompts.Prompt;
import ir.ac.kntu.services.app.scenes.managers.SceneManager;
import ir.ac.kntu.services.game.core.GameEngine;

public interface PromptFactory {
    Prompt getExitPrompt();
    Prompt getPausePrompt();
    void setGameEngine(GameEngine gameEngine);
    void setSceneManager(SceneManager sceneManager);
}