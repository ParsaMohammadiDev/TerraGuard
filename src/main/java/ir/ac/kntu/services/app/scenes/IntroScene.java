package ir.ac.kntu.services.app.scenes;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class IntroScene implements SceneLogic {
    private static final String NAME_ICON_PATH = "/app/name_icon.png";

    private final AnimationFactory animFactory;

    public IntroScene(AnimationFactory animFactory) {
        this.animFactory = animFactory;
    }

    @Override
    public Scene getScene() {
        StackPane root = new StackPane();
        Image nameIcon = new Image(NAME_ICON_PATH);
        ImageView nameIconView = new ImageView(nameIcon);
        animFactory.getZoomAndFadeAnimation().animate(nameIconView);
        root.getChildren().add(nameIconView);
        Scene scene = new Scene(root, 1200, 650);
        scene.getStylesheets().add(getClass().getResource("/style/intro_scene_style.css").toExternalForm());
        return scene;
    }
}