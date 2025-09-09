package ir.ac.kntu.services.app.scenes.managers;

import ir.ac.kntu.services.app.scenes.factories.SceneFactory;
import javafx.animation.PauseTransition;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SimpleSceneManager implements SceneManager {
    private static final Duration INTRO_DURATION = Duration.seconds(2);

    private final Stage stage;
    private SceneFactory sceneFactory;

    public SimpleSceneManager(Stage stage) {
        this.stage = stage;
    }

    public void setSceneFactory(SceneFactory sceneFactory) {
        this.sceneFactory = sceneFactory;
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

    @Override
    public void showGameOver() {
        stage.setScene(sceneFactory.getGameOverScene());
    }
}