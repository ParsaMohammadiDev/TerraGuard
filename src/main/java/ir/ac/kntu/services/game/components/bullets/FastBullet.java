package ir.ac.kntu.services.game.components.bullets;

public class FastBullet extends Bullet {
    private static final double SPEED = 15.0;
    private static final double COLLISION_MARGIN = 30;
    private static final double DAMAGE_COEFFICIENT = 1;

    public FastBullet() {
        super(BulletType.FAST_BULLET, SPEED, DAMAGE_COEFFICIENT);
    }

    @Override
    public double getCollisionMargin() {
        return COLLISION_MARGIN;
    }
}