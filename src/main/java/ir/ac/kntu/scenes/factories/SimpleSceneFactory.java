package ir.ac.kntu.scenes.factories;

import ir.ac.kntu.animations.factories.AnimationFactory;
import ir.ac.kntu.database.DataManager;
import ir.ac.kntu.game.GameEngine;
import ir.ac.kntu.scenes.*;
import ir.ac.kntu.scenes.managers.SceneManager;
import javafx.scene.Scene;

public class SimpleSceneFactory implements SceneFactory {
    private final AnimationFactory animFactory;
    private final SceneManager sceneManager;
    private final DataManager dataManager;
    private GameEngine gameEngine;

    public SimpleSceneFactory(AnimationFactory animFactory, SceneManager sceneManager, GameEngine gameEngine, DataManager dataManager) {
        this.animFactory = animFactory;
        this.sceneManager = sceneManager;
        this.gameEngine = gameEngine;
        this.dataManager = dataManager;
    }

    @Override
    public Scene getIntroScene() {
        return new IntroScene(animFactory).getScene();
    }

    @Override
    public Scene getMenuScene() {
        return new MenuScene(animFactory, sceneManager).getScene();
    }

    @Override
    public Scene getGameScene() {
        return new GameScene(gameEngine).getScene();
    }

    @Override
    public Scene getMapSelectorScene() {
        return new MapSelectorScene(dataManager, animFactory, gameEngine, sceneManager).getScene();
    }

    @Override
    public Scene getDifficultySelectorScene() {
        return new DifficultySelectorScene(sceneManager, animFactory, gameEngine).getScene();
    }
}