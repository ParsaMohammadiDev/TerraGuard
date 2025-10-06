package ir.ac.kntu.services.game.core.managers.strategies;

import ir.ac.kntu.services.game.components.Collidable;
import ir.ac.kntu.services.game.components.Entity;
import ir.ac.kntu.services.game.components.bullets.Bullet;
import ir.ac.kntu.services.game.core.renderers.EffectRenderer;

public class SimpleCollisionHandler implements CollisionHandler {
    private final EffectRenderer effectRenderer;

    public SimpleCollisionHandler(EffectRenderer effectRenderer) {
        this.effectRenderer = effectRenderer;
    }

    @Override
    public void collide(Bullet bullet, Collidable collidable) {
        if (!(collidable instanceof Entity entity)) return;
        effectRenderer.playBulletImpactEffect(bullet);
        entity.damage(bullet.getDamageCoefficient());
    }
}