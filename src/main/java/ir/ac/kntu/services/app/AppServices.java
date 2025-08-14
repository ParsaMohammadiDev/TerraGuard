package ir.ac.kntu.services.app;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.database.DataManager;
import ir.ac.kntu.services.app.scenes.factories.SceneFactory;
import ir.ac.kntu.services.app.scenes.managers.SceneManager;

public interface AppServices {
    SceneManager getSceneManager();
    AnimationFactory getAnimationFactory();
    DataManager getDataManager();
    SceneFactory getSceneFactory();
    void setSceneManager(SceneManager sceneManager);
    void setAnimationFactory(AnimationFactory animationFactory);
    void setDataManager(DataManager dataManager);
    void setSceneFactory(SceneFactory sceneFactory);
}