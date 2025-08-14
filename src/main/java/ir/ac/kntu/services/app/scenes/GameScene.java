package ir.ac.kntu.services.app.scenes;

import ir.ac.kntu.services.game.GameServices;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GameScene implements SceneLogic {
    private GameServices gameServices;

    public GameScene(GameServices gameServices) {
        this.gameServices = gameServices;
    }

    @Override
    public Scene getScene() {
        VBox root = new VBox();
        HBox sceneElements = new HBox();
        sceneElements.getStyleClass().add("scene_elements");
        Pane gamePane = gameServices.getGameEngine().getGamePane();
        gamePane.getStyleClass().add("game_pane");
        sceneElements.getChildren().add(gamePane);
        root.getChildren().add(sceneElements);
        Scene scene = new Scene(root, 1200, 650);
        scene.getStylesheets().add(getClass().getResource("/style/game_scene_style.css").toExternalForm());
        return scene;
    }
}