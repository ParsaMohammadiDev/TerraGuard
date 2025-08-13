package ir.ac.kntu.scenes.managers;

import ir.ac.kntu.animations.factories.AnimationFactory;
import ir.ac.kntu.animations.factories.SimpleAnimationFactory;
import ir.ac.kntu.database.DataManager;
import ir.ac.kntu.database.HardCodedDataManager;
import ir.ac.kntu.game.GameEngine;
import ir.ac.kntu.game.KenneyGameEngine;
import ir.ac.kntu.scenes.factories.SceneFactory;
import ir.ac.kntu.scenes.factories.SimpleSceneFactory;
import javafx.animation.PauseTransition;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SimpleSceneManager implements SceneManager {
    private static final Duration INTRO_DURATION = Duration.seconds(2);

    private final Stage stage;
    private GameEngine gameEngine;
    private final SceneFactory sceneFactory;
    private final AnimationFactory animFactory;
    private final DataManager dataManager;

    public SimpleSceneManager(Stage stage) {
        this.stage = stage;
        animFactory = new SimpleAnimationFactory();
        dataManager = new HardCodedDataManager();
        gameEngine = new KenneyGameEngine(animFactory);
        this.sceneFactory = new SimpleSceneFactory(animFactory, this, gameEngine, dataManager);
    }

    @Override
    public void showIntro() {
        stage.setScene(sceneFactory.getIntroScene());
        stage.show();
        PauseTransition introPause = new PauseTransition(INTRO_DURATION);
        introPause.setOnFinished(event -> showMenu());
        introPause.play();
    }

    @Override
    public void showMenu() {
        stage.setScene(sceneFactory.getMenuScene());
    }

    @Override
    public void showGame() {
        stage.setScene(sceneFactory.getGameScene());
    }

    @Override
    public void showMapSelector() {
        stage.setScene(sceneFactory.getMapSelectorScene());
    }

    @Override
    public void showDifficultySelector() {
        stage.setScene(sceneFactory.getDifficultySelectorScene());
    }
}