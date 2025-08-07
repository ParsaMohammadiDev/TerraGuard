package ir.ac.kntu.Scenes.Factories;

import ir.ac.kntu.Animations.Factories.AnimationFactory;
import ir.ac.kntu.Animations.Factories.SimpleAnimationFactory;
import ir.ac.kntu.Scenes.IntroScene;
import javafx.scene.Scene;

public class SimpleSceneFactory implements SceneFactory {
    @Override
    public Scene getIntroScene() {
        AnimationFactory animFactory = new SimpleAnimationFactory();
        return new IntroScene.Builder().withAnimationFactory(animFactory).build().getScene();
    }
}
