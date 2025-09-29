package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.game.components.Collidable;
import ir.ac.kntu.services.game.components.Entity;
import ir.ac.kntu.services.game.components.bullets.Bullet;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import java.util.List;

public class SimpleCollisionManager implements CollisionManager {
    private final List<? extends Collidable> entities;

    public SimpleCollisionManager(EnemyManager enemyManager) {
        entities = enemyManager.getEnemies();
    }

    @Override
    public boolean isCollided(Bullet bullet) {
        Bounds bulletBounds = getCollisionBounds(bullet);
        for (Collidable entity : entities) {
            Bounds enemyBounds = getCollisionBounds(entity);
            if (enemyBounds.intersects(bulletBounds)) {
                // logic of impact will be here
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isCollidedWithPaneBounds(Collidable entity, Pane pane) {
        Bounds bulletBounds = entity.getView().getBoundsInParent();
        Bounds paneBounds = pane.getLayoutBounds();
        return !paneBounds.contains(bulletBounds);
    }

    private Bounds getCollisionBounds(Collidable entity) {
        Bounds rawBounds = entity.getView().getBoundsInParent();
        double collisionMargin = entity.getCollisionMargin();
        return new BoundingBox(
                rawBounds.getMinX() + collisionMargin,
                rawBounds.getMinY() + collisionMargin,
                Math.max(0, rawBounds.getWidth() - 2 * collisionMargin),
                Math.max(0, rawBounds.getHeight() - 2 * collisionMargin)
        );
    }
}