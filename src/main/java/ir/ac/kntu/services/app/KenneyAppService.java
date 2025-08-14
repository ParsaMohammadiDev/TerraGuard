package ir.ac.kntu.services.app;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.database.DataManager;
import ir.ac.kntu.services.app.scenes.factories.SceneFactory;
import ir.ac.kntu.services.app.scenes.managers.SceneManager;

public class KenneyAppService implements AppServices {
    private SceneManager sceneManager;
    private AnimationFactory animFactory;
    private DataManager dataManager;
    private SceneFactory sceneFactory;

    @Override
    public DataManager getDataManager() {
        return dataManager;
    }

    @Override
    public AnimationFactory getAnimationFactory() {
        return animFactory;
    }

    @Override
    public SceneManager getSceneManager() {
        return sceneManager;
    }

    @Override
    public SceneFactory getSceneFactory() {
        return sceneFactory;
    }

    @Override
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @Override
    public void setAnimationFactory(AnimationFactory animationFactory) {
        this.animFactory = animationFactory;
    }

    @Override
    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void setSceneFactory(SceneFactory sceneFactory) {
        this.sceneFactory = sceneFactory;
    }
}
