package ir.ac.kntu.services.app.scenes.managers;

import ir.ac.kntu.services.app.AppServices;
import javafx.animation.PauseTransition;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SimpleSceneManager implements SceneManager {
    private static final Duration INTRO_DURATION = Duration.seconds(2);

    private final Stage stage;
    private final AppServices appServices;

    public SimpleSceneManager(Stage stage, AppServices appServices) {
        this.stage = stage;
        this.appServices = appServices;
    }

    @Override
    public void showIntro() {
        stage.setScene(appServices.getSceneFactory().getIntroScene());
        stage.show();
        PauseTransition introPause = new PauseTransition(INTRO_DURATION);
        introPause.setOnFinished(event -> showMenu());
        introPause.play();
    }

    @Override
    public void showMenu() {
        stage.setScene(appServices.getSceneFactory().getMenuScene());
    }

    @Override
    public void showGame() {
        stage.setScene(appServices.getSceneFactory().getGameScene());
    }

    @Override
    public void showMapSelector() {
        stage.setScene(appServices.getSceneFactory().getMapSelectorScene());
    }

    @Override
    public void showDifficultySelector() {
        stage.setScene(appServices.getSceneFactory().getDifficultySelectorScene());
    }
}