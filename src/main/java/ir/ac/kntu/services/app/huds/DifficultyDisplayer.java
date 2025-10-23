package ir.ac.kntu.services.app.huds;

import ir.ac.kntu.services.game.core.difficulties.DifficultySubscriber;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;
import ir.ac.kntu.services.game.core.difficulties.publishers.LevelPublisher;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class DifficultyDisplayer implements HUD, DifficultySubscriber {
    private final Text difficultyText = new Text();

    public DifficultyDisplayer(LevelPublisher levelPublisher) {
        levelPublisher.addSubscriber(this);
    }

    @Override
    public Node getNode() {
        return difficultyText;
    }

    @Override
    public void update(GameDifficulty difficulty) {
        difficultyText.setText(difficulty.toString());
    }
}
