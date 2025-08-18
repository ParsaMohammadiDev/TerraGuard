package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.components.enemies.factories.EnemyFactory;
import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;
import ir.ac.kntu.services.game.core.spawners.EnemyRenderer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class SimpleEnemyManager implements EnemyManager {
    private static final int SOLIDER_COUNT_SEED = 5;
    private static final int SOLIDER_SPAWN_RATE_SEED = 4;
    private static final int SOLDIER_SPEED_SEED = 30;

    private final EnemyFactory enemyFactory;
    private final EnemyRenderer enemyRenderer;

    public SimpleEnemyManager(EnemyFactory enemyFactory, EnemyRenderer enemyRenderer) {
        this.enemyFactory = enemyFactory;
        this.enemyRenderer = enemyRenderer;
    }

    @Override
    public void runEnemies(GameDifficulty difficulty, Map map) {
        runSoldiers(difficulty, map);
    }

    private void runSoldiers(GameDifficulty difficulty, Map map) {
        int soldierCount = (int) (difficulty.getDifficultyCoefficient() * SOLIDER_COUNT_SEED);
        double spawnRate = 1000 * SOLIDER_SPAWN_RATE_SEED * Math.pow(difficulty.getDifficultyCoefficient(), -1);
        double soldierSpeed = difficulty.getDifficultyCoefficient() * SOLDIER_SPEED_SEED;

        Timeline timeline = new Timeline();
        timeline.setCycleCount(soldierCount);

        KeyFrame keyFrame = new KeyFrame(
                Duration.millis(spawnRate),
                event -> {
                    Enemy newSoldier = enemyFactory.getSolider(map);
                    newSoldier.setSpeed(soldierSpeed);
                    enemyRenderer.addEnemy(newSoldier);
                }
        );

        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
}