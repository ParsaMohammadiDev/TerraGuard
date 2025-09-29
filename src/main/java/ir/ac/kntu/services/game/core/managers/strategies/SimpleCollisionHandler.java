package ir.ac.kntu.services.game.core.managers.strategies;

import ir.ac.kntu.services.game.components.Collidable;
import ir.ac.kntu.services.game.components.Entity;
import ir.ac.kntu.services.game.components.bullets.Bullet;

public class SimpleCollisionHandler implements CollisionHandler {
    @Override
    public void collide(Bullet bullet, Collidable collidable) {
        if (!(collidable instanceof Entity entity)) return;
        entity.damage(bullet.getDamageCoefficient());
    }
}