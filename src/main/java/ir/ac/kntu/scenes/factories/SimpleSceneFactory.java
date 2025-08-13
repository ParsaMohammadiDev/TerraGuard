package ir.ac.kntu.scenes.factories;

import ir.ac.kntu.animations.factories.AnimationFactory;
import ir.ac.kntu.components.maps.renderers.MapRenderer;
import ir.ac.kntu.database.DataManager;
import ir.ac.kntu.game.GameEngine;
import ir.ac.kntu.scenes.GameScene;
import ir.ac.kntu.scenes.IntroScene;
import ir.ac.kntu.scenes.MapSelectorScene;
import ir.ac.kntu.scenes.MenuScene;
import ir.ac.kntu.scenes.managers.SceneManager;
import javafx.scene.Scene;

public class SimpleSceneFactory implements SceneFactory {
    private final AnimationFactory animFactory;
    private final SceneManager sceneManager;
    private final GameEngine gameEngine;
    private final DataManager dataManager;

    public SimpleSceneFactory(AnimationFactory animFactory, SceneManager sceneManager, GameEngine gameEngine, DataManager dataManager) {
        this.animFactory = animFactory;
        this.sceneManager = sceneManager;
        this.gameEngine = gameEngine;
        this.dataManager = dataManager;
    }

    @Override
    public Scene getIntroScene() {
        return new IntroScene.Builder().withAnimationFactory(animFactory).build().getScene();
    }

    @Override
    public Scene getMenuScene() {
        return new MenuScene.Builder().withAnimationFactory(animFactory).withSceneManager(sceneManager).build().getScene();
    }

    @Override
    public Scene getGameScene() {
        return new GameScene.Builder().withGameEngine(gameEngine).build().getScene();
    }

    @Override
    public Scene getMapSelectorScene() {
        return new MapSelectorScene.Builder().withAnimationFactory(animFactory).withDataManager(dataManager).withGameEngine(gameEngine).withSceneManager(sceneManager).build().getScene();
    }
}
