package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.game.components.Entity;
import ir.ac.kntu.services.game.components.bullets.Bullet;
import ir.ac.kntu.services.game.components.enemies.Enemy;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import java.util.List;

public class SimpleCollisionManager implements CollisionManager {
    private final List<Enemy> enemies;

    public SimpleCollisionManager(EnemyManager enemyManager) {
        this.enemies = enemyManager.getEnemies();
    }

    @Override
    public boolean isCollided(Bullet bullet) {
        return false;
    }

    @Override
    public boolean isCollidedWithPaneBounds(Node node, Pane pane) {
        Bounds bulletBounds = node.getBoundsInParent();
        Bounds paneBounds = pane.getLayoutBounds();
        return !paneBounds.contains(bulletBounds);
    }
}