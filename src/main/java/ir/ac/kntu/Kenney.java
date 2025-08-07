package ir.ac.kntu;

import ir.ac.kntu.Scenes.Factories.SceneFactory;
import ir.ac.kntu.Scenes.Factories.SimpleSceneFactory;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Kenney extends Application {
    private static final String APP_NAME = "Kenney";
    private static final String APP_VERSION = "1.0-Beta";
    private static final String ICON_PATH = "/app/icon.png";

    private SceneFactory sceneFactory = new SimpleSceneFactory();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        setAppData(primaryStage);
        primaryStage.setScene(sceneFactory.getIntroScene());
        primaryStage.show();
    }

    public void setAppData(Stage stage) {
        stage.setTitle(APP_NAME);
        stage.getIcons().add(new Image(ICON_PATH));
    }
}