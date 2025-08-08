package ir.ac.kntu.Scenes.Factories;

import ir.ac.kntu.Animations.Factories.AnimationFactory;
import ir.ac.kntu.Animations.Factories.SimpleAnimationFactory;
import ir.ac.kntu.Scenes.IntroScene;
import ir.ac.kntu.Scenes.MenuScene;
import javafx.scene.Scene;

public class SimpleSceneFactory implements SceneFactory {
    private static final AnimationFactory animFactory = new SimpleAnimationFactory();
    @Override
    public Scene getIntroScene() {
        return new IntroScene.Builder().withAnimationFactory(animFactory).build().getScene();
    }

    @Override
    public Scene getMenuScene() {
        return new MenuScene.Builder().withAnimationFactory(animFactory).build().getScene();
    }
}
