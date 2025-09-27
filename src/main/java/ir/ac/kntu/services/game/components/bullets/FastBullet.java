package ir.ac.kntu.services.game.components.bullets;

public class FastBullet extends Bullet {
    private static final double SPEED = 15.0;

    public FastBullet() {
        super(BulletType.FAST_BULLET, SPEED);
    }
}