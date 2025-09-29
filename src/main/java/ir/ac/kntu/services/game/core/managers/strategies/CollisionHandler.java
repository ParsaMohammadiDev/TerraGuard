package ir.ac.kntu.services.game.core.managers.strategies;

import ir.ac.kntu.services.game.components.Collidable;
import ir.ac.kntu.services.game.components.bullets.Bullet;

public interface CollisionHandler {
    void collide(Bullet bullet, Collidable collidable);
}