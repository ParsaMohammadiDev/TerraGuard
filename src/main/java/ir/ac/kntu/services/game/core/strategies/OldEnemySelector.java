package ir.ac.kntu.services.game.core.strategies;

import ir.ac.kntu.services.game.components.defenders.Defender;
import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.core.managers.EnemyManager;

import java.util.List;

public class OldEnemySelector implements EnemySelector {
    private List<Enemy> enemies;

    public OldEnemySelector(EnemyManager enemyManager) {
        enemies = enemyManager.getEnemies();
    }
    @Override
    public Enemy selectEnemy(Defender defender) {
        if (enemies.size() == 0) return null;
        return enemies.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return enemies.isEmpty();
    }
}