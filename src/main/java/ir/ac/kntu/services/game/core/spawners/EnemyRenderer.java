package ir.ac.kntu.services.game.core.spawners;

import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.core.managers.EnemyManager;
import javafx.scene.layout.Pane;

public interface EnemyRenderer {
    Pane renderEnemies();
    void addEnemy(Enemy enemy, EnemyManager enemyManager);
    void reset();
}