package ir.ac.kntu.services.app.prompts;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.scenes.managers.SceneManager;
import ir.ac.kntu.services.game.core.GameEngine;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PausePrompt implements Prompt {
    private static final long PROMPT_WIDTH = 600;
    private static final long PROMPT_HEIGHT = 300;
    private static final String PROMPT_TEXT = "Do you want to leave?";

    private final AnimationFactory animFactory;
    private final GameEngine gameEngine;
    private final SceneManager sceneManager;

    private Pane promptPane;

    public PausePrompt(GameEngine gameEngine, AnimationFactory animFactory, SceneManager sceneManager, Stage stage) {
        this.gameEngine = gameEngine;
        this.sceneManager = sceneManager;
        this.animFactory = animFactory;
        setPane();
        Pane root = (Pane) stage.getScene().getRoot();
        if (!root.getChildren().contains(promptPane)) {
            root.getChildren().add(promptPane);
        }
    }

    @Override
    public void showPrompt() {
        promptPane.setVisible(true);
        animFactory.getFadeAnimation().animate(promptPane.getChildren().getFirst());
        animFactory.getZoomAndFadeAnimation().animate(promptPane.getChildren().getLast());
    }

    private void setPane() {
        promptPane = new StackPane();
        promptPane.getChildren().addAll(getBackground(), getPromptPane());
        promptPane.getStylesheets().add(getClass().getResource("/style/pause_prompt_style.css").toExternalForm());
        promptPane.setVisible(false);
    }

    private Pane getBackground() {
        Pane background = new Pane();
        background.getStyleClass().add("prompt_background");
        return background;
    }

    private Pane getPromptPane() {
        VBox menuPane = new VBox();
        menuPane.setMaxWidth(PROMPT_WIDTH);
        menuPane.setMaxHeight(PROMPT_HEIGHT);
        menuPane.getStyleClass().add("prompt_pane");
        Text pauseText = new Text("Game paused");
        setTextStyle(70, 4, pauseText);
        menuPane.getChildren().addAll(pauseText, getPauseButtons());
        return menuPane;
    }

    private Pane getPauseButtons() {
        HBox buttons = new HBox();
        buttons.getStyleClass().add("prompt_buttons");
        Button exitButton = new Button("Exit");
        Button resumeButton = new Button("Resume");
        animFactory.getButtonHoverAnimation().animate(exitButton, resumeButton);
        exitButton.setOnAction(e -> {
            gameEngine.hardReset();
            sceneManager.showMenu();
        });
        resumeButton.setOnAction(e -> {
            promptPane.setVisible(false);
            gameEngine.resume();
        });
        buttons.getChildren().addAll(exitButton, resumeButton);
        return buttons;
    }

    private void setTextStyle(double size, double stroke, Text... texts) {
        for (Text text : texts) {
            text.setFont(Font.font("Berlin Sans FB", FontWeight.EXTRA_BOLD, size));
            text.setFill(Color.WHITE);
            text.setStroke(Color.rgb(39, 39, 39));
            text.setStrokeWidth(stroke);
            text.getStyleClass().add("page_title");
        }
    }
}
