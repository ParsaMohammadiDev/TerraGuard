package ir.ac.kntu.scenes;

import ir.ac.kntu.animations.factories.AnimationFactory;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class IntroScene implements SceneLogic {
    private static final String NAME_ICON_PATH = "/app/name_icon.png";

    private AnimationFactory animFactory;

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
        return new Scene(root, 1200, 650, Color.rgb(3, 177, 252));
    }

    public static class Builder {
        private AnimationFactory animFactory;

        public Builder withAnimationFactory(AnimationFactory animFactory) {
            this.animFactory = animFactory;
            return this;
        }

        public IntroScene build() {
            if (animFactory != null) {
                return new IntroScene(animFactory);
            } else {
                throw new IllegalStateException("Animation Factory must be set");
            }
        }
    }
}