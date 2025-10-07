package ir.ac.kntu.services.app.scenes;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.scenes.managers.SceneManager;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MenuScene implements SceneLogic {
    private static final String SCENE_STYLE_PATH = "/style/menu_scene_style.css";
    private static final String NAME_ICON_PATH = "/app/name_icon.png";

    private final SceneManager sceneManager;
    private final AnimationFactory animFactory;

    public MenuScene(SceneManager sceneManager, AnimationFactory animFactory) {
        this.sceneManager = sceneManager;
        this.animFactory = animFactory;
    }

    @Override
    public Scene getScene() {
        StackPane root = new StackPane();
        VBox menuItems = new VBox();
        Pane buttons = getButtons();
        Node nameIcon = getNameIcon();
        animFactory.getZoomAndFadeAnimation().animate(nameIcon, buttons);
        menuItems.getStyleClass().add("menu_items");
        menuItems.getChildren().addAll(nameIcon, buttons);
        root.getChildren().add(menuItems);
        Scene scene = new Scene(root, 1200, 650);
        scene.getStylesheets().add(getClass().getResource(SCENE_STYLE_PATH).toExternalForm());
        return scene;
    }

    private Node getNameIcon() {
        ImageView nameIcon = new ImageView(new Image(NAME_ICON_PATH));
        nameIcon.setPreserveRatio(true);
        nameIcon.setFitHeight(300);
        nameIcon.getStyleClass().add("name_icon");
        return nameIcon;
    }

    private Pane getButtons() {
        HBox buttons = new HBox();
        Button startGame = new Button("Start Game");
        startGame.setOnAction(event -> sceneManager.showGame());
        Button selectMap = new Button("Select Map");
        selectMap.setOnAction(event -> sceneManager.showMapSelector());
        Button difficulty = new Button("Game Difficulty");
        difficulty.setOnAction(event -> {sceneManager.showDifficultySelector();});
        buttons.getChildren().addAll(startGame, selectMap, difficulty);
        buttons.getStyleClass().add("buttons");
        animFactory.getButtonHoverAnimation().animate(startGame, selectMap, difficulty);
        return buttons;
    }
}
