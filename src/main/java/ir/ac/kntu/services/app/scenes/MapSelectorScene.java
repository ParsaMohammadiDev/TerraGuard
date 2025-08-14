package ir.ac.kntu.services.app.scenes;

import ir.ac.kntu.services.app.AppServices;
import ir.ac.kntu.services.game.GameServices;
import ir.ac.kntu.services.game.components.maps.Map;
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
    private final AppServices appServices;
    private final GameServices gameServices;

    private List<Map> mapsList;
    private int mapsNum;
    private int currentMapIndex = 0;
    private ImageView mapThumbnailView;

    public MapSelectorScene(AppServices appServices, GameServices gameServices) {
        this.appServices = appServices;
        this.gameServices = gameServices;
        mapsList = appServices.getDataManager().loadMapsList();
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
        appServices.getAnimationFactory().getButtonHoverAnimation().animate(next, prev); // keep UI consistent
        return navigator;
    }

    private Button createSelectButton() {
        Button select = new Button("Select");
        select.getStyleClass().add("select_button");
        select.setOnAction(event -> {
            gameServices.getGameEngine().setGameMap(mapsList.get(currentMapIndex));
            appServices.getSceneManager().showMenu();
        });
        appServices.getAnimationFactory().getButtonHoverAnimation().animate(select);
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
        mapThumbnailView.setImage(gameServices.getMapRenderer().renderMapImage(mapsList.get(currentMapIndex)));
    }

    private int getCurrentMapIndex() {
        return mapsList.indexOf(gameServices.getGameEngine().getGameMap());
    }
}