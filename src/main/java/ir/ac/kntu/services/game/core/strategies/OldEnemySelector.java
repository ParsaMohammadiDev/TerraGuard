package ir.ac.kntu.services.game.core.strategies;

import ir.ac.kntu.services.game.components.defenders.Defender;
import ir.ac.kntu.services.game.components.enemies.Enemy;

import java.util.List;

public class OldEnemySelector implements EnemySelector {
    @Override
    public Enemy selectEnemy(List<Enemy> enemies, Defender defender) {
        if (enemies.size() == 0) return null;
        return enemies.getFirst();
    }
}