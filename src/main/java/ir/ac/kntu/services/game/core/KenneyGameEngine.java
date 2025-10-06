package ir.ac.kntu.services.game.core;

import ir.ac.kntu.services.app.scenes.managers.SceneManager;
import ir.ac.kntu.services.game.core.difficulties.publishers.LevelPublisher;
import ir.ac.kntu.services.game.core.managers.BulletManager;
import ir.ac.kntu.services.game.components.maps.GrassLand;
import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.components.maps.renderers.MapRenderer;
import ir.ac.kntu.services.game.components.wallets.Wallet;
import ir.ac.kntu.services.game.components.wallets.generators.CoinGenerator;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;
import ir.ac.kntu.services.game.core.difficulties.factories.DifficultyFactory;
import ir.ac.kntu.services.game.core.managers.DefenderManager;
import ir.ac.kntu.services.game.core.managers.DifficultyManager;
import ir.ac.kntu.services.game.core.managers.EnemyManager;
import ir.ac.kntu.services.game.core.renderers.EnemyRenderer;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class KenneyGameEngine implements GameEngine {
    private static final double ENEMY_OVERCOME_PERCENTAGE = 0.5;

    private final MapRenderer mapRenderer;
    private final EnemyRenderer enemyRenderer;
    private final EnemyManager enemyManager;
    private final CoinGenerator coinGenerator;
    private final SceneManager sceneManager;
    private final BulletManager bulletManager;
    private final DefenderManager defenderManager;
    private final Wallet wallet;
    private final DifficultyManager difficultyManager;

    private Map gameMap;
    private GameDifficulty difficulty;
    private boolean isReset = true;
    private boolean isPause = false;

    private final StackPane gamePane = new StackPane();

    public KenneyGameEngine(MapRenderer mapRenderer,
                            EnemyRenderer enemyRenderer,
                            EnemyManager enemyManager,
                            DifficultyFactory difficultyFactory,
                            CoinGenerator coinGenerator,
                            SceneManager sceneManager,
                            Wallet wallet,
                            BulletManager bulletManager,
                            DefenderManager defenderManager,
                            DifficultyManager difficultyManager) {
        this.mapRenderer = mapRenderer;
        this.enemyRenderer = enemyRenderer;
        this.enemyManager = enemyManager;
        this.coinGenerator = coinGenerator;
        this.difficulty = difficultyFactory.getEasyDifficulty();
        this.bulletManager = bulletManager;
        this.sceneManager = sceneManager;
        this.defenderManager = defenderManager;
        this.difficultyManager = difficultyManager;
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
        if (!isReset) return gamePane;
        difficultyManager.setGameEngine(this);
        gamePane.getChildren().clear();
        enemyManager.runEnemies(difficulty, gameMap, this);
        coinGenerator.generate();
        gamePane.getChildren().add(mapRenderer.renderMap(gameMap));
        gamePane.getChildren().add(enemyRenderer.renderEnemies());
        gamePane.getChildren().add(bulletManager.renderBullets());
        gamePane.getChildren().add(mapRenderer.renderOverlay(gameMap));
        isReset = false;
        return gamePane;
    }

    @Override
    public void checkGameStatus(int initEnemyCount, int reachedEnemyCount, int terminatedEnemyCount) {
        if (reachedEnemyCount >= initEnemyCount * ENEMY_OVERCOME_PERCENTAGE) gameOver();
        if (terminatedEnemyCount == initEnemyCount) levelUp();
    }

    @Override
    public void resume() {
        coinGenerator.generate();
        if(!isPause) {
            enemyManager.runEnemies(difficulty, gameMap, this);
        } else {
            isPause = false;
            defenderManager.resume();
            enemyManager.resume();
            bulletManager.resume();
        }
    }

    private void gameOver() {
        hardReset();
        enemyManager.reset();
        bulletManager.reset();
        defenderManager.reset();
        sceneManager.showGameOver();
    }

    private void levelUp() {
        coinGenerator.stop();
        enemyManager.reset();
        bulletManager.reset();
        difficultyManager.levelUp(difficulty);
    }

    @Override
    public void hardReset() {
        isPause = false;
        isReset = true;
        enemyManager.reset();
        bulletManager.reset();
        difficultyManager.reset();
        defenderManager.reset();
        coinGenerator.stop();
        wallet.reset();
    }

    @Override
    public void pause() {
        isPause = true;
        coinGenerator.stop();
        enemyManager.pause();
        bulletManager.pause();
        defenderManager.pause();
    }
}