package ir.ac.kntu.scenes.factories;

import ir.ac.kntu.animations.factories.AnimationFactory;
import ir.ac.kntu.scenes.IntroScene;
import ir.ac.kntu.scenes.MenuScene;
import ir.ac.kntu.scenes.managers.SceneManager;
import javafx.scene.Scene;

public class SimpleSceneFactory implements SceneFactory {
    private final AnimationFactory animFactory;
    private final SceneManager sceneManager;

    public SimpleSceneFactory(AnimationFactory animFactory, SceneManager sceneManager) {
        this.animFactory = animFactory;
        this.sceneManager = sceneManager;
    }

    @Override
    public Scene getIntroScene() {
        return new IntroScene.Builder().withAnimationFactory(animFactory).build().getScene();
    }

    @Override
    public Scene getMenuScene() {
        return new MenuScene.Builder().withAnimationFactory(animFactory).withSceneManager(sceneManager).build().getScene();
    }
}
