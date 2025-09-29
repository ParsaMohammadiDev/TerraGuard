package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.game.components.Collidable;
import ir.ac.kntu.services.game.components.bullets.Bullet;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public interface CollisionManager {
    boolean isCollided(Bullet bullet);
    boolean isCollidedWithPaneBounds(Collidable entity, Pane pane);
}