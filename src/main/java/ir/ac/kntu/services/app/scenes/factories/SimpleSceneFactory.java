package ir.ac.kntu.services.app.scenes.factories;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.database.DataManager;
import ir.ac.kntu.services.app.huds.factories.HUDFactory;
import ir.ac.kntu.services.app.menus.factories.MenuFactory;
import ir.ac.kntu.services.app.scenes.*;
import ir.ac.kntu.services.app.scenes.managers.SceneManager;
import ir.ac.kntu.services.game.components.maps.renderers.MapRenderer;
import ir.ac.kntu.services.game.core.GameEngine;
import ir.ac.kntu.services.game.core.difficulties.factories.DifficultyFactory;
import javafx.scene.Scene;

public class SimpleSceneFactory implements SceneFactory {
    private final GameEngine gameEngine;
    private final MapRenderer mapRenderer;
    private final DifficultyFactory difficultyFactory;
    private final SceneManager sceneManager;
    private final DataManager dataManager;
    private final AnimationFactory animFactory;
    private final HUDFactory hudFactory;
    private final MenuFactory menuFactory;

    public SimpleSceneFactory(GameEngine gameEngine, MapRenderer mapRenderer, DifficultyFactory difficultyFactory, SceneManager sceneManager, DataManager dataManager, AnimationFactory animFactory, HUDFactory hudFactory, MenuFactory menuFactory) {
        this.gameEngine = gameEngine;
        this.mapRenderer = mapRenderer;
        this.sceneManager = sceneManager;
        this.dataManager = dataManager;
        this.animFactory = animFactory;
        this.difficultyFactory = difficultyFactory;
        this.hudFactory = hudFactory;
        this.menuFactory = menuFactory;
    }

    @Override
    public Scene getIntroScene() {
        return new IntroScene(animFactory).getScene();
    }

    @Override
    public Scene getMenuScene() {
        return new MenuScene(sceneManager, animFactory).getScene();
    }

    @Override
    public Scene getGameScene() {
        return new GameScene(gameEngine, hudFactory, menuFactory, animFactory, sceneManager).getScene();
    }

    @Override
    public Scene getMapSelectorScene() {
        return new MapSelectorScene(gameEngine, mapRenderer, dataManager, animFactory, sceneManager).getScene();
    }

    @Override
    public Scene getDifficultySelectorScene() {
        return new DifficultySelectorScene(gameEngine, difficultyFactory, sceneManager, animFactory).getScene();
    }

    @Override
    public Scene getGameOverScene() {
        return new GameOverScene(animFactory, sceneManager).getScene();
    }

    @Override
    public Scene getLevelUpScene() {
        return new LevelUpScene(animFactory, gameEngine, sceneManager).getScene();
    }
}