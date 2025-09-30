package ir.ac.kntu.services.game.core.strategies;

import ir.ac.kntu.services.game.components.defenders.Defender;
import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.core.managers.EnemyManager;
import java.util.List;
import java.util.Random;

public class RandomEnemySelector implements EnemySelector {
    private final List<Enemy> enemies;

    public RandomEnemySelector(EnemyManager enemyManager) {
        enemies = enemyManager.getEnemies();
    }

    @Override
    public Enemy selectEnemy(Defender defender) {
        Random random = new Random();
        return enemies.get(random.nextInt(enemies.size()));
    }

    @Override
    public boolean isEmpty() {
        return enemies.isEmpty();
    }
}
