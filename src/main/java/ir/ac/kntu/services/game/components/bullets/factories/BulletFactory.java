package ir.ac.kntu.services.game.components.bullets.factories;

import ir.ac.kntu.services.game.components.bullets.Bullet;
import ir.ac.kntu.services.game.components.bullets.BulletType;

public interface BulletFactory {
    Bullet getBullet(BulletType type);
}