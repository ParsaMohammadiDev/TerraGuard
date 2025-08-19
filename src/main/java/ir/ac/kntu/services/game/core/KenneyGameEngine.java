package ir.ac.kntu.services.game.core;

import ir.ac.kntu.services.game.components.maps.GrassLand;
import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.components.maps.renderers.MapRenderer;
import ir.ac.kntu.services.game.components.wallets.generators.CoinGenerator;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;
import ir.ac.kntu.services.game.core.difficulties.factories.DifficultyFactory;
import ir.ac.kntu.services.game.core.managers.EnemyManager;
import ir.ac.kntu.services.game.core.spawners.EnemyRenderer;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class KenneyGameEngine implements GameEngine {
    private final MapRenderer mapRenderer;
    private final EnemyRenderer enemyRenderer;
    private final EnemyManager enemyManager;
    private final CoinGenerator coinGenerator;

    private Map gameMap;
    private GameDifficulty difficulty;

    public KenneyGameEngine(MapRenderer mapRenderer, EnemyRenderer enemyRenderer, EnemyManager enemyManager, DifficultyFactory difficultyFactory, CoinGenerator coinGenerator) {
        this.mapRenderer = mapRenderer;
        this.enemyRenderer = enemyRenderer;
        this.enemyManager = enemyManager;
        this.coinGenerator = coinGenerator;
        this.difficulty = difficultyFactory.getEasyDifficulty();
        this.gameMap = new GrassLand();
    }

    @Override
    public Pane getGamePane() {
        startGame();
        StackPane gamePane = new StackPane();
        gamePane.getChildren().add(mapRenderer.renderMap(gameMap));
        gamePane.getChildren().add(enemyRenderer.renderEnemies());
        gamePane.getChildren().add(mapRenderer.renderOverlay(gameMap));
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

    @Override
    public void startGame() {
        enemyManager.runEnemies(difficulty, gameMap);
        coinGenerator.generate();
    }
}