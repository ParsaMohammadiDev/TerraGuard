package ir.ac.kntu.services.app.scenes;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.scenes.managers.SceneManager;
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

public class GameOverScene implements SceneLogic {
    private final AnimationFactory animFactory;
    private final SceneManager sceneManager;

    public GameOverScene(AnimationFactory animFactory, SceneManager sceneManager) {
        this.animFactory = animFactory;
        this.sceneManager = sceneManager;
    }

    @Override
    public Scene getScene() {
        VBox elements = new VBox();
        elements.getChildren().addAll(getTitle(), getButtons());
        Scene scene = new Scene(elements, 1200, 650);
        scene.getStylesheets().add(getClass().getResource("/style/game_over_scene_style.css").toExternalForm());
        return scene;
    }

    private Node getTitle() {
        Text title = new Text("Game Over!");
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
        Button playAgain = new Button("Play Again");
        exit.setOnAction(e -> {sceneManager.showMenu();});
        playAgain.setOnAction(e -> {sceneManager.showGame();});
        buttons.getChildren().addAll(exit, playAgain);
        buttons.getStyleClass().add("buttons");
        animFactory.getButtonHoverAnimation().animate(exit, playAgain);
        return buttons;
    }
}
