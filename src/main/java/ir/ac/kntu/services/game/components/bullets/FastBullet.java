package ir.ac.kntu.services.game.components.bullets;

public class FastBullet extends Bullet {
    private static final double SPEED = 15.0;
    private static final double COLLISION_MARGIN = 30;

    public FastBullet() {
        super(BulletType.FAST_BULLET, SPEED);
    }

    @Override
    public double getCollisionMargin() {
        return COLLISION_MARGIN;
    }
}