package ir.ac.kntu.services.game.core.renderers;

import ir.ac.kntu.services.game.components.Shooter;
import ir.ac.kntu.services.game.components.bullets.Bullet;

public interface EffectRenderer {
    void rotateMuzzle(Shooter shooter, double angle);
    void playBulletImpactEffect(Bullet bullet);
}