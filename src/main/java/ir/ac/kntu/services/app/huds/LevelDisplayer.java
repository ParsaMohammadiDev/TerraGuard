package ir.ac.kntu.services.app.huds;

import ir.ac.kntu.services.game.core.difficulties.LevelSubscriber;
import ir.ac.kntu.services.game.core.difficulties.publishers.LevelPublisher;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class LevelDisplayer implements HUD, LevelSubscriber {
    private Text levelText = new Text();

    public LevelDisplayer(LevelPublisher levelPublisher) {
        levelPublisher.addSubscriber(this);
    }

    @Override
    public Node getNode() {
        return levelText;
    }

    @Override
    public void update(int level) {
        levelText.setText(Integer.toString(level));
    }
}