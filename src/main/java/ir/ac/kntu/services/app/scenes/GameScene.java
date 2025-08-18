package ir.ac.kntu.services.app.scenes;

import ir.ac.kntu.services.game.core.GameEngine;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GameScene implements SceneLogic {
    private final GameEngine gameEngine;

    public GameScene(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public Scene getScene() {
        VBox root = new VBox();
        HBox sceneElements = new HBox();
        sceneElements.getStyleClass().add("scene_elements");
        Pane gamePane = gameEngine.getGamePane();
        gamePane.getStyleClass().add("game_pane");
        sceneElements.getChildren().add(gamePane);
        root.getChildren().add(sceneElements);
        Scene scene = new Scene(root, 1200, 650);
        scene.getStylesheets().add(getClass().getResource("/style/game_scene_style.css").toExternalForm());
        return scene;
    }
}