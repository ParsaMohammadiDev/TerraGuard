package ir.ac.kntu.services.app.scenes;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.scenes.managers.SceneManager;
import ir.ac.kntu.services.game.core.GameEngine;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;
import ir.ac.kntu.services.game.core.difficulties.factories.DifficultyFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DifficultySelectorScene implements SceneLogic {
    private final GameEngine gameEngine;
    private final DifficultyFactory difficultyFactory;
    private final SceneManager sceneManager;
    private final AnimationFactory animFactory;

    private Slider difficultySlider;

    public DifficultySelectorScene(GameEngine gameEngine, DifficultyFactory difficultyFactory, SceneManager sceneManager, AnimationFactory animFactory) {
        this.gameEngine = gameEngine;
        this.difficultyFactory = difficultyFactory;
        this.sceneManager = sceneManager;
        this.animFactory = animFactory;
    }

    @Override
    public Scene getScene() {
        VBox root = new VBox();
        VBox difficultySelector = new VBox();
        difficultySelector.getChildren().addAll(createSliderLabels(), createSlider());
        difficultySelector.getStyleClass().add("difficulty_selector");
        root.getChildren().addAll(createPageTitle(), difficultySelector, createSelectButton());
        Scene scene = new Scene(root, 1200, 650);
        scene.getStylesheets().add(getClass().getResource("/style/difficulty_selector_scene_style.css").toExternalForm());
        return scene;
    }

    private Slider createSlider() {
        difficultySlider = new Slider(0, 2, 0);
        difficultySlider.setValue(gameEngine.getGameDifficulty().enumerate());
        difficultySlider.setMaxWidth(400);
        difficultySlider.setMajorTickUnit(1);
        difficultySlider.setMinorTickCount(1);
        difficultySlider.setMinorTickCount(0);
        difficultySlider.setSnapToTicks(true);
        difficultySlider.setShowTickMarks(false);
        difficultySlider.setShowTickLabels(false);
        difficultySlider.getStyleClass().add("slider");
        return difficultySlider;
    }

    private Text createPageTitle() {
        Text title = new Text("Choose difficulty");
        title.setFont(Font.font("Berlin Sans FB", FontWeight.EXTRA_BOLD, 90));
        title.setFill(Color.WHITE);
        title.setStroke(Color.rgb(39, 39, 39));
        title.setStrokeWidth(5);
        title.getStyleClass().add("page_title");
        return title;
    }

    private Button createSelectButton() {
        Button select = new Button("Select");
        select.getStyleClass().add("select_button");
        select.setOnAction(event -> {
            gameEngine.setGameDifficulty(getDifficultyFromSliderValue((int) (difficultySlider.getValue())));
            sceneManager.showMenu();
        });
        animFactory.getButtonHoverAnimation().animate(select);
        return select;
    }

    private HBox createSliderLabels() {
        HBox labels = new HBox();
        Text easyLabel = new Text("Easy");
        Text mediumLabel = new Text("Medium");
        Text hardLabel = new Text("Hard");
        styleText(easyLabel);
        styleText(mediumLabel);
        styleText(hardLabel);
        labels.getChildren().addAll(easyLabel, mediumLabel, hardLabel);
        labels.getStyleClass().add("slider_labels");
        return labels;
    }

    private void styleText(Text text) {
        text.setFont(Font.font("Berlin Sans FB", FontWeight.EXTRA_BOLD, 50));
        text.setFill(Color.WHITE);
        text.setStroke(Color.rgb(39, 39, 39));
        text.setStrokeWidth(3);
        text.getStyleClass().add("slider_label");
    }

    private GameDifficulty getDifficultyFromSliderValue(int value) {
        return switch (value) {
            case 0 -> difficultyFactory.getEasyDifficulty();
            case 1 -> difficultyFactory.getMediumDifficulty();
            case 2 -> difficultyFactory.getHardDifficulty();
            default -> throw new IllegalStateException("Unexpected Slider value");
        };
    }
}