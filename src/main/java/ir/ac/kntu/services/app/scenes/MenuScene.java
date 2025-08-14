package ir.ac.kntu.services.app.scenes;

import ir.ac.kntu.services.app.AppServices;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MenuScene implements SceneLogic {
    private static final String SCENE_STYLE_PATH = "/style/menu_scene_style.css";
    private static final String NAME_ICON_PATH = "/app/name_icon.png";

    private AppServices appServices;

    public MenuScene(AppServices appServices) {
        this.appServices = appServices;
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
        startGame.setOnAction(event -> appServices.getSceneManager().showGame());
        Button selectMap = new Button("Select Map");
        selectMap.setOnAction(event -> appServices.getSceneManager().showMapSelector());
        Button difficulty = new Button("Game Difficulty");
        difficulty.setOnAction(event -> {appServices.getSceneManager().showDifficultySelector();});
        buttons.getChildren().addAll(startGame, selectMap, difficulty);
        buttons.getStyleClass().add("buttons");
        menuItems.getChildren().addAll(nameIcon, buttons);
        Scene scene = new Scene(menuItems, 1200, 650);
        scene.getStylesheets().add(getClass().getResource(SCENE_STYLE_PATH).toExternalForm());
        appServices.getAnimationFactory().getZoomAndFadeAnimation().animate(nameIcon, buttons);
        appServices.getAnimationFactory().getButtonHoverAnimation().animate(startGame, selectMap, difficulty);
        return scene;
    }
}
