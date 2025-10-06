package ir.ac.kntu.services.game.core.renderers;

import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.core.managers.EnemyManager;
import javafx.scene.layout.Pane;

import java.util.List;

public interface EnemyRenderer {
    Pane renderEnemies();
    void addEnemy(Enemy enemy);
    void reset();
    void setEnemyManager(EnemyManager enemyManager);
    void pause();
    void resume();
}