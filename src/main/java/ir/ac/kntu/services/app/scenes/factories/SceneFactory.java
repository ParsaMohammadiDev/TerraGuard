package ir.ac.kntu.services.app.scenes.factories;

import javafx.scene.Scene;

public interface SceneFactory {
    Scene getIntroScene();
    Scene getMenuScene();
    Scene getGameScene();
    Scene getMapSelectorScene();
    Scene getDifficultySelectorScene();
    Scene getGameOverScene();
}
