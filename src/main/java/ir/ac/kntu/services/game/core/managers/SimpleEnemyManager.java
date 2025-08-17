package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.game.GameServices;
import ir.ac.kntu.services.game.components.enemies.Enemy;

public class SimpleEnemyManager implements EnemyManager {
    private static final int SOLIDER_COUNT_SEED = 5;
    private static final int SOLIDER_SPAWN_RATE_SEED = 4;


    private GameServices gameServices;
    private int soldierCount = 0;


    public SimpleEnemyManager(GameServices gameService) {
        this.gameServices = gameService;
        soldierCount = (int) (Math.ceil(SOLIDER_COUNT_SEED * gameService.getGameEngine().getGameDifficulty().getDifficultyCoefficient()));
    }

    @Override
    public void runEnemies() {
        runSoldiers();
    }

    private void runSoldiers() {
        Enemy newSoldier = gameServices.getEnemyServices().getEnemyFactory().getSolider();
        gameServices.getEnemyServices().getEnemyRenderer().addEnemy(newSoldier);
    }
}