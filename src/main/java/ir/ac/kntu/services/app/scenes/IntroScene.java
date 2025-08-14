package ir.ac.kntu.services.app.scenes;

import ir.ac.kntu.services.app.AppServices;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class IntroScene implements SceneLogic {
    private static final String NAME_ICON_PATH = "/app/name_icon.png";

    private final AppServices appServices;

    public IntroScene(AppServices appServices) {
        this.appServices = appServices;
    }

    @Override
    public Scene getScene() {
        StackPane root = new StackPane();
        Image nameIcon = new Image(NAME_ICON_PATH);
        ImageView nameIconView = new ImageView(nameIcon);
        appServices.getAnimationFactory().getZoomAndFadeAnimation().animate(nameIconView);
        root.getChildren().add(nameIconView);
        return new Scene(root, 1200, 650, Color.rgb(3, 177, 252));
    }
}