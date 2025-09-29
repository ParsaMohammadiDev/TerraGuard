package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.game.components.bullets.Bullet;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class SimpleCollisionManager implements CollisionManager {
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