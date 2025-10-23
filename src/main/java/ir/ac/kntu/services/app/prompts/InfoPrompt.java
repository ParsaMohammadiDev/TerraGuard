package ir.ac.kntu.services.app.prompts;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.database.AppDataManager;
import ir.ac.kntu.services.app.database.AppInfo;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InfoPrompt implements Prompt {
    private static final double PROMPT_WIDTH = 700;
    private static final double PROMPT_HEIGHT = 500;

    private final AppDataManager dataManager;
    private final AnimationFactory animFactory;

    private Pane promptPane;

    public InfoPrompt(AnimationFactory animFactory, AppDataManager dataManager, Stage stage) {
        this.dataManager = dataManager;
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
        promptPane.getStylesheets().add(getClass().getResource("/style/info_prompt_style.css").toExternalForm());
        promptPane.setVisible(false);
    }

    private Pane getBackground() {
        Pane background = new Pane();
        background.getStyleClass().add("prompt_background");
        return background;
    }

    private Pane getPromptPane() {
        AppInfo appInfo = dataManager.getAppInfo();
        VBox main = new VBox();
        main.setMaxWidth(PROMPT_WIDTH);
        main.setMaxHeight(PROMPT_HEIGHT);
        Text version = new Text("Version: " + appInfo.getVersion());
        Text build = new Text("Build: " + getBuild(appInfo));
        Text repo = new Text("Repository: " + appInfo.getRepo());
        setTextStyle(20, 1.25, version, build, repo);
        Button ok = new Button("OK");
        animFactory.getButtonHoverAnimation().animate(ok);
        ok.setOnAction(e -> {
            promptPane.setVisible(false);
        });
        main.getChildren().addAll(getNameIcon(), version, build, repo, ok);
        main.getStyleClass().add("prompt_pane");
        return main;
    }

    private String getBuild(AppInfo appInfo) {
        long rawData = appInfo.getBuild();
        return new SimpleDateFormat("yyyyMMddHHmmss").format(rawData);
    }

    private ImageView getNameIcon() {
        ImageView nameIcon = new ImageView("/app/name_icon.png");
        nameIcon.setPreserveRatio(true);
        nameIcon.setFitHeight(200);
        return nameIcon;
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
