package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.components.enemies.factories.EnemyFactory;
import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.core.GameEngine;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;
import ir.ac.kntu.services.game.core.renderers.EnemyRenderer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class SimpleEnemyManager implements EnemyManager {
    private static final int SOLIDER_COUNT_SEED = 5;
    private static final int SOLIDER_SPAWN_RATE_SEED = 4;
    private static final int SOLDIER_SPEED_SEED = 30;
    private static final double ENEMY_OVERCOME_PERCENTAGE = 0.5;

    private final EnemyFactory enemyFactory;
    private final EnemyRenderer enemyRenderer;
    private final List<Enemy> enemies = new ArrayList<>();
    private GameEngine gameEngine;

    private Timeline soldierManager;

    private int initEnemyCount = 0;
    private int reachedEnemyCount = 0;
    private int terminatedEnemyCount = 0;

    public SimpleEnemyManager(EnemyFactory enemyFactory, EnemyRenderer enemyRenderer) {
        this.enemyFactory = enemyFactory;
        this.enemyRenderer = enemyRenderer;
        enemyRenderer.setEnemyManager(this);
    }

    @Override
    public void runEnemies(GameDifficulty difficulty, Map map, GameEngine gameEngine) {
        runSoldiers(difficulty, map);
        this.gameEngine = gameEngine;
    }

    @Override
    public void reachEnemy(Enemy enemy) {
        reachedEnemyCount ++;
        enemies.remove(enemy);
        gameEngine.checkGameStatus(initEnemyCount, reachedEnemyCount, terminatedEnemyCount);
    }

    @Override
    public void terminateEnemy(Enemy enemy) {
        terminatedEnemyCount ++;
        enemies.remove(enemy);
        gameEngine.checkGameStatus(initEnemyCount, reachedEnemyCount, terminatedEnemyCount);
    }

    @Override
    public List<Enemy> getEnemies() {
        return enemies;
    }

    private void runSoldiers(GameDifficulty difficulty, Map map) {
        int soldierCount = (int) (difficulty.getDifficultyCoefficient() * SOLIDER_COUNT_SEED);
        initEnemyCount += soldierCount;
        double spawnRate = 1000 * SOLIDER_SPAWN_RATE_SEED * Math.pow(difficulty.getDifficultyCoefficient(), -1);
        double soldierSpeed = difficulty.getDifficultyCoefficient() * SOLDIER_SPEED_SEED;

        soldierManager = new Timeline();
        soldierManager.setCycleCount(soldierCount);

        KeyFrame keyFrame = new KeyFrame(
                Duration.millis(spawnRate),
                event -> {
                    Enemy newSoldier = enemyFactory.getSolider(map);
                    newSoldier.setSpeed(soldierSpeed);
                    enemyRenderer.addEnemy(newSoldier);
                }
        );

        soldierManager.getKeyFrames().add(keyFrame);
        soldierManager.play();
    }

    public void reset() {
        reachedEnemyCount = 0;
        terminatedEnemyCount = 0;
        initEnemyCount = 0;
        enemyRenderer.reset();
        if (soldierManager != null) soldierManager.stop();
    }
}