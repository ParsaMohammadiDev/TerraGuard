package ir.ac.kntu.scenes;

import ir.ac.kntu.animations.factories.AnimationFactory;
import ir.ac.kntu.scenes.managers.SceneManager;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MenuScene implements SceneLogic {
    private static final String SCENE_STYLE_PATH = "/style/menu_scene_style.css";
    private static final String NAME_ICON_PATH = "/app/name_icon.png";

    private AnimationFactory animFactory;
    private SceneManager sceneManager;

    public MenuScene(AnimationFactory animFactory, SceneManager sceneManager) {
        this.animFactory = animFactory;
        this.sceneManager = sceneManager;
    }

    @Override
    public Scene getScene() {
        VBox menuItems = new VBox();
        HBox buttons = new HBox();
        ImageView nameIcon = new ImageView(new Image(NAME_ICON_PATH));
        nameIcon.setPreserveRatio(true);
        nameIcon.setFitHeight(300);
        nameIcon.getStyleClass().add("name_icon");
        Button startGame = new Button("Start Game");
        startGame.setOnAction(event -> sceneManager.showGame());
        Button selectMap = new Button("Select Map");
        selectMap.setOnAction(event -> sceneManager.showMapSelector());
        Button hardness = new Button("Game Hardness");
        buttons.getChildren().addAll(startGame, selectMap, hardness);
        buttons.getStyleClass().add("buttons");
        menuItems.getChildren().addAll(nameIcon, buttons);
        Scene scene = new Scene(menuItems, 1200, 650);
        scene.getStylesheets().add(getClass().getResource(SCENE_STYLE_PATH).toExternalForm());
        animFactory.getZoomAndFadeAnimation().animate(nameIcon, buttons);
        animFactory.getButtonHoverAnimation().animate(startGame, selectMap, hardness);
        return scene;
    }
}
