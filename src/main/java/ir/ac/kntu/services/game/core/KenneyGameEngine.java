package ir.ac.kntu.services.game.core;

import ir.ac.kntu.services.game.GameServices;
import ir.ac.kntu.services.game.components.maps.GrassLand;
import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class KenneyGameEngine implements GameEngine {
    private final GameServices gameServices;

    private Map gameMap;
    private GameDifficulty difficulty;

    public KenneyGameEngine(GameServices gameServices) {
        this.gameServices = gameServices;
        this.difficulty = gameServices.getDifficultyFactory().getEasyDifficulty();
        this.gameMap = new GrassLand();
    }

    @Override
    public Pane getGamePane() {
        StackPane gamePane = new StackPane();
        gamePane.getChildren().add(gameServices.getMapRenderer().renderMap(gameMap));
        return gamePane;
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