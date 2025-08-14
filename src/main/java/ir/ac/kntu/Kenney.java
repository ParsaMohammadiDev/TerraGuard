package ir.ac.kntu;

import ir.ac.kntu.services.app.animations.factories.SimpleAnimationFactory;
import ir.ac.kntu.services.game.components.maps.renderers.GridMapRenderer;
import ir.ac.kntu.services.game.components.tiles.factories.FlyWeightTileFactory;
import ir.ac.kntu.services.app.database.HardCodedDataManager;
import ir.ac.kntu.services.game.core.KenneyGameEngine;
import ir.ac.kntu.services.game.core.difficulties.factories.SimpleDifficultyFactory;
import ir.ac.kntu.services.app.scenes.factories.SceneFactory;
import ir.ac.kntu.services.app.scenes.factories.SimpleSceneFactory;
import ir.ac.kntu.services.app.scenes.managers.SimpleSceneManager;
import ir.ac.kntu.services.app.AppServices;
import ir.ac.kntu.services.game.GameServices;
import ir.ac.kntu.services.app.KenneyAppService;
import ir.ac.kntu.services.game.KenneyGameServices;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Kenney extends Application {
    private static final String APP_NAME = "Kenney";
    private static final String APP_VERSION = "1.0-Beta";
    private static final String ICON_PATH = "/app/icon.png";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        setAppData(primaryStage);
        AppServices appServices = setServices(primaryStage);
        appServices.getSceneManager().showIntro();
    }

    public void setAppData(Stage stage) {
        stage.setTitle(APP_NAME);
        stage.getIcons().add(new Image(ICON_PATH));
    }

    private AppServices setServices(Stage primaryStage) {
        AppServices appServices = new KenneyAppService();
        GameServices gameServices = new KenneyGameServices();
        SceneFactory sceneFactory = new SimpleSceneFactory(appServices, gameServices);

        appServices.setSceneFactory(sceneFactory);
        appServices.setSceneManager(new SimpleSceneManager(primaryStage, appServices));
        appServices.setAnimationFactory(new SimpleAnimationFactory());
        appServices.setDataManager(new HardCodedDataManager());

        gameServices.setTileFactory(new FlyWeightTileFactory(appServices));
        gameServices.setMapRenderer(new GridMapRenderer(gameServices.getTileFactory()));
        gameServices.setDifficultyFactory(new SimpleDifficultyFactory());
        gameServices.setGameEngine(new KenneyGameEngine(gameServices));

        return appServices;
    }
}