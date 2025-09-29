package ir.ac.kntu.services.app.scenes.managers;

import ir.ac.kntu.services.app.scenes.factories.SceneFactory;

public interface SceneManager {
    void showIntro();
    void showMenu();
    void showGame();
    void showMapSelector();
    void showGameOver();
    void showLevelUp();
    void showDifficultySelector();
    void setSceneFactory(SceneFactory sceneFactory);
}
