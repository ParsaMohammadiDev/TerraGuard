package ir.ac.kntu.services.app.prompts;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
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

public class ExitPrompt implements Prompt {
    private static final long PROMPT_WIDTH = 600;
    private static final long PROMPT_HEIGHT = 300;
    private static final String PROMPT_TEXT = "Do you want to leave?";

    private final AnimationFactory animFactory;
    private final GameEngine gameEngine;
    private final Stage stage;

    private Pane promptPane;

    public ExitPrompt(GameEngine gameEngine, AnimationFactory animFactory, Stage stage) {
        this.stage = stage;
        this.animFactory = animFactory;
        this.gameEngine = gameEngine;
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
        promptPane.getStylesheets().add(getClass().getResource("/style/exit_prompt_style.css").toExternalForm());
        promptPane.setVisible(false);
    }

    private Pane getBackground() {
        Pane background = new Pane();
        background.getStyleClass().add("prompt_background");
        return background;
    }

    private Pane getPromptPane() {
        Pane pane = new VBox();
        pane.setMaxWidth(PROMPT_WIDTH);
        pane.setMaxHeight(PROMPT_HEIGHT);
        pane.getStyleClass().add("prompt_pane");
        Text label = new Text(PROMPT_TEXT);
        setTextStyle(50, 3, label);
        pane.getChildren().addAll(label, getPromptButtons());
        return pane;
    }

    private Pane getPromptButtons() {
        HBox buttons = new HBox();
        buttons.getStyleClass().add("prompt_buttons");
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        yesButton.setOnAction(e -> {
            gameEngine.hardReset();
            stage.close();
        });
        noButton.setOnAction(e -> {
            promptPane.setVisible(false);
        });
        animFactory.getButtonHoverAnimation().animate(yesButton, noButton);
        buttons.getChildren().addAll(yesButton, noButton);
        return buttons;
    }

    private void setTextStyle(double size, double stroke, Text... texts) {
        for (Text text : texts) {
            text.setFont(Font.font("Berlin Sans FB", FontWeight.EXTRA_BOLD, size));
            text.setFill(javafx.scene.paint.Color.WHITE);
            text.setStroke(Color.rgb(39, 39, 39));
            text.setStrokeWidth(stroke);
            text.getStyleClass().add("page_title");
        }
    }
}
