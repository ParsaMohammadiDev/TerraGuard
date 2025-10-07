package ir.ac.kntu.services.app.prompts.factories;

import ir.ac.kntu.services.app.prompts.Prompt;
import ir.ac.kntu.services.game.core.GameEngine;

public interface PromptFactory {
    Prompt getExitPrompt();
    void setGameEngine(GameEngine gameEngine);
}