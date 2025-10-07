package ir.ac.kntu.services.app.prompts.managers;

import ir.ac.kntu.services.app.prompts.Prompt;
import ir.ac.kntu.services.app.prompts.factories.PromptFactory;
import javafx.scene.layout.Pane;

public class SimplePromptManager implements PromptManager {
    private final PromptFactory promptFactory;

    private Pane pane;

    public SimplePromptManager(PromptFactory promptFactory) {
        this.promptFactory = promptFactory;
    }

    @Override
    public void showExitPrompt() {
        Prompt prompt = promptFactory.getExitPrompt();
        prompt.showPrompt();
    }

    @Override
    public void showPausePrompt() {
        Prompt prompt = promptFactory.getPausePrompt();
        prompt.showPrompt();
    }
}