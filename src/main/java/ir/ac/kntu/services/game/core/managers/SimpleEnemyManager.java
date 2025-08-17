package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.game.GameServices;
import ir.ac.kntu.services.game.components.enemies.Enemy;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class SimpleEnemyManager implements EnemyManager {
    private static final int SOLIDER_COUNT_SEED = 5;
    private static final int SOLIDER_SPAWN_RATE_SEED = 4;
    private static final int SOLDIER_SPEED_SEED = 30;

    private GameServices gameServices;

    public SimpleEnemyManager(GameServices gameService) {
        this.gameServices = gameService;
    }

    @Override
    public void runEnemies() {
        runSoldiers();
    }

    private void runSoldiers() {
        int soldierCount = (int) (gameServices.getGameEngine()
                .getGameDifficulty().getDifficultyCoefficient() * SOLIDER_COUNT_SEED);
        double spawnRate = 1000 * SOLIDER_SPAWN_RATE_SEED * Math
                .pow(gameServices.getGameEngine().getGameDifficulty().getDifficultyCoefficient(), -1);
        double soldierSpeed = gameServices.getGameEngine()
                .getGameDifficulty().getDifficultyCoefficient() * SOLDIER_SPEED_SEED;

        Timeline timeline = new Timeline();
        timeline.setCycleCount(soldierCount);

        KeyFrame keyFrame = new KeyFrame(
                Duration.millis(spawnRate),
                event -> {
                    Enemy newSoldier = gameServices.getEnemyServices()
                            .getEnemyFactory().getSolider();
                    newSoldier.setSpeed(soldierSpeed);
                    gameServices.getEnemyServices()
                            .getEnemyRenderer().addEnemy(newSoldier);
                }
        );

        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
}