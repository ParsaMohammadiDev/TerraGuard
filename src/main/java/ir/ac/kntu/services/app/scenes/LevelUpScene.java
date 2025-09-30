package ir.ac.kntu.services.app.scenes;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.scenes.managers.SceneManager;
import ir.ac.kntu.services.game.core.GameEngine;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LevelUpScene implements SceneLogic {
    private final AnimationFactory animFactory;
    private final GameEngine gameEngine;
    private final SceneManager sceneManager;

    public LevelUpScene(AnimationFactory animFactory, GameEngine gameEngine, SceneManager sceneManager) {
        this.gameEngine = gameEngine;
        this.animFactory = animFactory;
        this.sceneManager = sceneManager;
    }

    @Override
    public Scene getScene() {
        VBox elements = new VBox();
        elements.getChildren().addAll(getTitle(), getButtons());
        Scene scene = new Scene(elements, 1200, 650);
        scene.getStylesheets().add(getClass().getResource("/style/level_up_scene_style.css").toExternalForm());
        return scene;
    }

    private Node getTitle() {
        Text title = new Text("Level Up!!!");
        title.setFont(Font.font("Berlin Sans FB", FontWeight.EXTRA_BOLD, 90));
        title.setFill(Color.WHITE);
        title.setStroke(Color.rgb(39, 39, 39));
        title.setStrokeWidth(5);
        title.getStyleClass().add("title");
        return title;
    }

    private Pane getButtons() {
        HBox buttons = new HBox();
        Button exit = new Button("Exit");
        Button continueButton = new Button("Continue");
        buttons.getChildren().addAll(exit, continueButton);
        buttons.getStyleClass().add("buttons");
        animFactory.getButtonHoverAnimation().animate(exit, continueButton);
        exit.setOnAction(e -> {
            gameEngine.hardReset();
            sceneManager.showMenu();
        });
        continueButton.setOnAction(e -> {
            gameEngine.resume();
            sceneManager.showGame();
        });
        return buttons;
    }
}