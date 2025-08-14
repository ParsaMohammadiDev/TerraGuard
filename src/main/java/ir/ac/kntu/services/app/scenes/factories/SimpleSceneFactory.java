package ir.ac.kntu.services.app.scenes.factories;

import ir.ac.kntu.services.app.AppServices;
import ir.ac.kntu.services.app.scenes.*;
import ir.ac.kntu.services.game.GameServices;
import javafx.scene.Scene;

public class SimpleSceneFactory implements SceneFactory {
    private final AppServices appServices;
    private final GameServices gameServices;

    public SimpleSceneFactory(AppServices appServices, GameServices gameServices) {
        this.appServices = appServices;
        this.gameServices = gameServices;
    }

    @Override
    public Scene getIntroScene() {
        return new IntroScene(appServices).getScene();
    }

    @Override
    public Scene getMenuScene() {
        return new MenuScene(appServices).getScene();
    }

    @Override
    public Scene getGameScene() {
        return new GameScene(gameServices).getScene();
    }

    @Override
    public Scene getMapSelectorScene() {
        return new MapSelectorScene(appServices, gameServices).getScene();
    }

    @Override
    public Scene getDifficultySelectorScene() {
        return new DifficultySelectorScene(appServices, gameServices).getScene();
    }
}