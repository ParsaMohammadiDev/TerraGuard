package ir.ac.kntu.services.game.components.bullets.factories;

import ir.ac.kntu.services.game.components.bullets.Bullet;
import ir.ac.kntu.services.game.components.bullets.BulletType;
import ir.ac.kntu.services.game.components.bullets.FastBullet;
import ir.ac.kntu.services.game.components.bullets.NormalBullet;

public class SimpleBulletFactory implements BulletFactory {
    @Override
    public Bullet getBullet(BulletType type) {
        return switch (type) {
            case NORMAL_BULLET -> new NormalBullet();
            case FAST_BULLET -> new FastBullet();
        };
    }
}