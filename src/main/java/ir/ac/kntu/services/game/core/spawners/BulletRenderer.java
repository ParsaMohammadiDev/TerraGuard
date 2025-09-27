package ir.ac.kntu.services.game.core.spawners;

import ir.ac.kntu.services.game.components.Entity;
import ir.ac.kntu.services.game.components.Shooter;
import ir.ac.kntu.services.game.components.bullets.Bullet;
import javafx.scene.layout.Pane;

public interface BulletRenderer {
    public void renderBullet(Bullet bullet, Shooter shooter, Entity target, Pane gamePane);
    void reset();
}