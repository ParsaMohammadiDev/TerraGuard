package ir.ac.kntu.services.app.scenes;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.huds.factories.HUDFactory;
import ir.ac.kntu.services.app.menus.factories.MenuFactory;
import ir.ac.kntu.services.app.scenes.managers.SceneManager;
import ir.ac.kntu.services.game.core.GameEngine;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GameScene implements SceneLogic {
    private static final String COIN_PATH = "/app/coin.png";

    private final GameEngine gameEngine;
    private final HUDFactory hudFactory;
    private final MenuFactory menuFactory;
    private final AnimationFactory animFactory;
    private final SceneManager sceneManager;

    private Pane pauseMenu;
    private Pane pauseBackground;

    public GameScene(GameEngine gameEngine,
                     HUDFactory hudFactory,
                     MenuFactory menuFactory,
                     AnimationFactory animFactory,
                     SceneManager sceneManager) {
        this.gameEngine = gameEngine;
        this.hudFactory = hudFactory;
        this.menuFactory = menuFactory;
        this.animFactory = animFactory;
        this.sceneManager = sceneManager;
        pauseBackground = getPauseMenuBackground();
        pauseMenu = getPauseMenu();
    }

    @Override
    public Scene getScene() {
        StackPane root = new StackPane();
        root.getChildren().addAll(getMainPane(), pauseBackground, pauseMenu);
        Scene scene = new Scene(root, 1200, 650);
        scene.getStylesheets().add(getClass().getResource("/style/game_scene_style.css").toExternalForm());
        return scene;
    }

    private Pane getMainPane() {
        VBox mainPane = new VBox();
        HBox sceneElements = new HBox();
        sceneElements.getStyleClass().add("scene_elements");
        Pane gameHUD = getGameHUD();
        Pane gamePane = gameEngine.startGame();
        gamePane.getStyleClass().add("game_pane");
        sceneElements.getChildren().addAll(gamePane, gameHUD);
        mainPane.getChildren().addAll(sceneElements, getPauseButton());
        return mainPane;
    }

    private Pane getPauseMenuBackground() {
        Pane background = new Pane();
        background.setVisible(false);
        background.getStyleClass().add("pause_menu_background");
        return background;
    }

    private Pane getPauseMenu() {
        VBox menuPane = new VBox();
        menuPane.setMaxWidth(600);
        menuPane.setMaxHeight(300);
        menuPane.getStyleClass().add("pause_menu");
        Text pauseText = new Text("Game paused");
        setTextStyle(70, 4, pauseText);
        menuPane.getChildren().addAll(pauseText, getPauseButtons());
        menuPane.setVisible(false);
        return menuPane;
    }

    private Pane getPauseButtons() {
        HBox buttons = new HBox();
        buttons.getStyleClass().add("pause_buttons");
        Button exitButton = new Button("Exit");
        Button resumeButton = new Button("Resume");
        animFactory.getButtonHoverAnimation().animate(exitButton, resumeButton);
        exitButton.setOnAction(e -> {
            gameEngine.hardReset();
            sceneManager.showMenu();
        });
        resumeButton.setOnAction(e -> {
            pauseMenu.setVisible(false);
            pauseBackground.setVisible(false);
            gameEngine.resume();
        });
        buttons.getChildren().addAll(exitButton, resumeButton);
        return buttons;
    }

    private Button getPauseButton() {
        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(e -> {
            gameEngine.pause();
            pauseBackground.setVisible(true);
            pauseMenu.setVisible(true);
            animFactory.getZoomAndFadeAnimation().animate(pauseMenu);
            animFactory.getFadeAnimation().animate(pauseBackground);
        });
        animFactory.getButtonHoverAnimation().animate(pauseButton);
        return pauseButton;
    }

    private Pane getGameHUD() {
        Pane gameHUD = new VBox();
        gameHUD.setPrefWidth(350);
        gameHUD.getChildren().addAll(
                getCoinsHUD(),
                getDifficultyHUD(),
                getLevelHUD(),
                menuFactory.getConstructionMenu().getView());
        gameHUD.getStyleClass().add("game_hud");
        return gameHUD;
    }

    private Pane getCoinsHUD() {
        Pane coinHUD = new HBox();
        ImageView coinIcon = new ImageView(new Image(COIN_PATH));
        coinIcon.setPreserveRatio(true);
        coinIcon.setFitWidth(40);
        Text coinText = new Text("Coins: ");
        Node coinValue = hudFactory.getCoinHUD();
        setTextStyle(40, 2, coinText, (Text) coinValue);
        coinHUD.getChildren().addAll(coinIcon, coinText, coinValue);
        coinHUD.getStyleClass().add("coin_hud");
        return coinHUD;
    }

    private Pane getLevelHUD() {
        Pane coinHUD = new HBox();
        Text levelText = new Text("Level: ");
        Node levelValue = hudFactory.getLevelHUD();
        setTextStyle(40, 2, levelText, (Text) levelValue);
        coinHUD.getChildren().addAll(levelText, levelValue);
        coinHUD.getStyleClass().add("level_hud");
        return coinHUD;
    }

    private Node getDifficultyHUD() {
        Text difficultyText = (Text) hudFactory.getDifficultyHUD();
        setTextStyle(40, 2, difficultyText);
        return difficultyText;
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