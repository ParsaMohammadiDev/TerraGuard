package ir.ac.kntu.scenes;

import ir.ac.kntu.animations.factories.AnimationFactory;
import ir.ac.kntu.components.maps.Map;
import ir.ac.kntu.database.DataManager;
import ir.ac.kntu.game.GameEngine;
import ir.ac.kntu.scenes.managers.SceneManager;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.List;

public class MapSelectorScene implements SceneLogic {
    private final DataManager dataManager;
    private final GameEngine gameEngine;
    private final AnimationFactory animFactory;
    private final SceneManager sceneManager;

    private List<Map> mapsList;
    private int mapsNum;
    private int currentMapIndex = 0;
    private ImageView mapThumbnailView;

    public MapSelectorScene(DataManager dataManager, AnimationFactory animFactory, GameEngine gameEngine, SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        this.dataManager = dataManager;
        this.gameEngine = gameEngine;
        this.animFactory = animFactory;
        mapsList = dataManager.loadMapsList();
        mapsNum = mapsList.size();
        currentMapIndex = getCurrentMapIndex();
    }

    @Override
    public Scene getScene() {
        VBox root = new VBox();
        root.getChildren().addAll(createPageTitle(), createNavigator(), createSelectButton());
        Scene scene = new Scene(root, 1200, 650);
        scene.getStylesheets().add(getClass().getResource("/style/map_selector_scene_style.css").toExternalForm());
        return scene;
    }

    private Text createPageTitle() {
        Text pageTitle = new Text("Choose a map");
        pageTitle.setFont(Font.font("Berlin Sans FB", FontWeight.EXTRA_BOLD, 90));
        pageTitle.setFill(Color.WHITE);
        pageTitle.setStroke(Color.rgb(39, 39, 39));
        pageTitle.setStrokeWidth(5);
        pageTitle.getStyleClass().add("page_title");
        return pageTitle;
    }

    private HBox createNavigator() {
        HBox navigator = new HBox();
        navigator.getStyleClass().add("navigator");
        mapThumbnailView = new ImageView();
        showMapThumbnail(currentMapIndex);
        mapThumbnailView.setPreserveRatio(true);
        mapThumbnailView.setFitWidth(450);
        StackPane thumbnailPane = new StackPane(mapThumbnailView);
        thumbnailPane.getStyleClass().add("map_thumbnail");
        Button next = new Button("⮞");
        Button prev = new Button("⮜");
        next.getStyleClass().add("navigator_button");
        prev.getStyleClass().add("navigator_button");
        next.setOnAction(event -> showMapThumbnail(getNextMapIndex()));
        prev.setOnAction(event -> showMapThumbnail(getPrevMapIndex()));
        navigator.getChildren().addAll(prev, thumbnailPane, next);
        animFactory.getButtonHoverAnimation().animate(next, prev); // keep UI consistent
        return navigator;
    }

    private Button createSelectButton() {
        Button select = new Button("Select");
        select.getStyleClass().add("select_button");
        select.setOnAction(event -> {
            gameEngine.setGameMap(mapsList.get(currentMapIndex));
            sceneManager.showMenu();
        });
        animFactory.getButtonHoverAnimation().animate(select);
        return select;
    }

    private int getNextMapIndex() {
        return (currentMapIndex + 1) % mapsNum;
    }

    private int getPrevMapIndex() {
        return (currentMapIndex - 1 + mapsNum) % mapsNum;
    }

    private void showMapThumbnail(int mapIndex) {
        currentMapIndex = mapIndex;
        mapThumbnailView.setImage(gameEngine.getMapRenderer().renderMapImage(mapsList.get(currentMapIndex)));
    }

    private int getCurrentMapIndex() {
        return mapsList.indexOf(gameEngine.getGameMap());
    }

    public static class Builder {
        private AnimationFactory animFactory;
        private DataManager dataManager;
        private GameEngine gameEngine;
        private SceneManager sceneManager;

        public Builder withAnimationFactory(AnimationFactory animFactory) {
            this.animFactory = animFactory;
            return this;
        }

        public Builder withDataManager(DataManager dataManager) {
            this.dataManager = dataManager;
            return this;
        }

        public Builder withGameEngine(GameEngine gameEngine) {
            this.gameEngine = gameEngine;
            return this;
        }


        public Builder withSceneManager(SceneManager sceneManager) {
            this.sceneManager = sceneManager;
            return this;
        }

        public MapSelectorScene build() {
            if (animFactory != null && dataManager != null && gameEngine != null && sceneManager != null) {
                return new MapSelectorScene(dataManager, animFactory, gameEngine, sceneManager);
            } else {
                throw new IllegalStateException("DataManager, GameEngine, AnimationFactory, and SceneManager must be set");
            }
        }
    }
}