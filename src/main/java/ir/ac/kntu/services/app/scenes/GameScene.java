package ir.ac.kntu.services.app.scenes;

import ir.ac.kntu.services.app.huds.factories.HUDFactory;
import ir.ac.kntu.services.app.menus.factories.MenuFactory;
import ir.ac.kntu.services.game.core.GameEngine;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GameScene implements SceneLogic {
    private static final String COIN_PATH = "/app/coin.png";

    private final GameEngine gameEngine;
    private final HUDFactory hudFactory;
    private final MenuFactory menuFactory;

    public GameScene(GameEngine gameEngine, HUDFactory hudFactory, MenuFactory menuFactory) {
        this.gameEngine = gameEngine;
        this.hudFactory = hudFactory;
        this.menuFactory = menuFactory;
    }

    @Override
    public Scene getScene() {
        VBox root = new VBox();
        HBox sceneElements = new HBox();
        sceneElements.getStyleClass().add("scene_elements");
        Pane gamePane = gameEngine.getGamePane();
        gamePane.getStyleClass().add("game_pane");
        sceneElements.getChildren().addAll(gamePane, getGameHUD());
        root.getChildren().add(sceneElements);
        Scene scene = new Scene(root, 1200, 650);
        scene.getStylesheets().add(getClass().getResource("/style/game_scene_style.css").toExternalForm());
        return scene;
    }

    private Pane getGameHUD() {
        Pane gameHUD = new VBox();
        gameHUD.setPrefWidth(350);
        gameHUD.getChildren().addAll(getCoinsHUD(), menuFactory.getConstructionMenu().getView());
        gameHUD.getStyleClass().add("game_hud");
        return gameHUD;
    }

    private Pane getCoinsHUD() {
        Pane coinHUD = new HBox();
        ImageView coinIcon = new ImageView(new Image(COIN_PATH));
        coinIcon.setPreserveRatio(true);
        coinIcon.setFitWidth(40);
        Text coinText = new Text("Coins: ");
        Node coinValue = hudFactory.getCoinHUD();
        setTextStyle(40, coinText, (Text) coinValue);
        coinHUD.getChildren().addAll(coinIcon, coinText, coinValue);
        coinHUD.getStyleClass().add("coin_hud");
        return coinHUD;
    }

    private void setTextStyle(double size, Text... texts) {
        for (Text text : texts) {
            text.setFont(Font.font("Berlin Sans FB", FontWeight.EXTRA_BOLD, size));
            text.setFill(Color.WHITE);
            text.setStroke(Color.rgb(39, 39, 39));
            text.setStrokeWidth(2);
            text.getStyleClass().add("page_title");
        }
    }
}