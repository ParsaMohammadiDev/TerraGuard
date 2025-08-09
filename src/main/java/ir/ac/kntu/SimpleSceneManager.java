package ir.ac.kntu;

import javafx.animation.PauseTransition;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SimpleSceneManager implements SceneManager {
    private static final Duration INTRO_DURATION = Duration.seconds(2);

    private final Stage stage;
    private final SceneFactory sceneFactory;

    public SimpleSceneManager(Stage stage) {
        this.stage = stage;
        AnimationFactory animFactory = new SimpleAnimationFactory();
        this.sceneFactory = new SimpleSceneFactory(animFactory, this);
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
}