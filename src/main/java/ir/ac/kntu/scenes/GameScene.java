package ir.ac.kntu.scenes;

import ir.ac.kntu.game.GameEngine;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class GameScene implements SceneLogic {
    private GameEngine gameEngine;

    public GameScene(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public Scene getScene() {
        StackPane gamePane = new StackPane();
        gamePane.getChildren().add(gameEngine.getGamePane());
        return new Scene(gamePane, 1200, 500);
    }

    public static class Builder {
        private GameEngine gameEngine;

        public Builder withGameEngine(GameEngine gameEngine) {
            this.gameEngine = gameEngine;
            return this;
        }

        public GameScene build() {
            if (gameEngine != null) {
                return new GameScene(gameEngine);
            } else {
                throw new IllegalStateException("GameEngine must be set");
            }
        }
    }
}
