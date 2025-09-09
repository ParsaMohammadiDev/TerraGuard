package ir.ac.kntu.services.game.core;

import ir.ac.kntu.services.app.scenes.managers.SceneManager;
import ir.ac.kntu.services.game.components.maps.GrassLand;
import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.components.maps.renderers.MapRenderer;
import ir.ac.kntu.services.game.components.wallets.Wallet;
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
    private final SceneManager sceneManager;
    private final Wallet wallet;

    private Map gameMap;
    private GameDifficulty difficulty;

    private final StackPane gamePane = new StackPane();

    public KenneyGameEngine(MapRenderer mapRenderer, EnemyRenderer enemyRenderer, EnemyManager enemyManager, DifficultyFactory difficultyFactory, CoinGenerator coinGenerator, SceneManager sceneManager, Wallet wallet) {
        this.mapRenderer = mapRenderer;
        this.enemyRenderer = enemyRenderer;
        this.enemyManager = enemyManager;
        this.coinGenerator = coinGenerator;
        this.difficulty = difficultyFactory.getEasyDifficulty();
        this.sceneManager = sceneManager;
        this.wallet = wallet;
        this.gameMap = new GrassLand();
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
    public Pane startGame() {
        gamePane.getChildren().clear();
        enemyManager.runEnemies(difficulty, gameMap, this);
        coinGenerator.generate();
        gamePane.getChildren().add(mapRenderer.renderMap(gameMap));
        gamePane.getChildren().add(enemyRenderer.renderEnemies());
        gamePane.getChildren().add(mapRenderer.renderOverlay(gameMap));
        return gamePane;
    }

    @Override
    public void gameOver() {
        difficulty.reset();
        coinGenerator.stop();
        wallet.reset();
        sceneManager.showGameOver();
    }
}