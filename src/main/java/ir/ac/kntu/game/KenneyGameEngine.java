package ir.ac.kntu.game;

import ir.ac.kntu.animations.factories.AnimationFactory;
import ir.ac.kntu.components.maps.GrassLand;
import ir.ac.kntu.components.maps.Map;
import ir.ac.kntu.components.maps.renderers.GridMapRenderer;
import ir.ac.kntu.components.maps.renderers.MapRenderer;
import ir.ac.kntu.components.tiles.factories.FlyWeightTileFactory;
import ir.ac.kntu.components.tiles.factories.TileFactory;
import ir.ac.kntu.game.difficulties.Easy;
import ir.ac.kntu.game.difficulties.GameDifficulty;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class KenneyGameEngine implements GameEngine {
    private final TileFactory tileFactory;
    private final MapRenderer mapRenderer;

    private Map gameMap = new GrassLand();
    private GameDifficulty difficulty = new Easy();

    public KenneyGameEngine(AnimationFactory animFactory) {
        tileFactory = new FlyWeightTileFactory(animFactory);
        mapRenderer = new GridMapRenderer(tileFactory);
        this.difficulty = new Easy();
        this.gameMap = new GrassLand();
    }

    @Override
    public Pane getGamePane() {
        StackPane gamePane = new StackPane();
        gamePane.getChildren().add(mapRenderer.renderMap(gameMap));
        return gamePane;
    }

    @Override
    public MapRenderer getMapRenderer() {
        return mapRenderer;
    }

    @Override
    public Map getGameMap() {
        return gameMap;
    }

    @Override
    public GameDifficulty getGameDifficulty() {
        return difficulty;
    }

    @Override
    public void setGameDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public void setGameMap(Map map) {
        this.gameMap = map;
    }
}