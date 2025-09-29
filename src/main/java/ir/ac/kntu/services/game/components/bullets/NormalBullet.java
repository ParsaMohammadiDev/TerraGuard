package ir.ac.kntu.services.game.components.bullets;

public class NormalBullet extends Bullet {
    private static final double SPEED = 10.0;
    private static final double COLLISION_MARGIN = 30;
    private static final double DAMAGE_COEFFICIENT = 2;

    public NormalBullet() {
        super(BulletType.NORMAL_BULLET, SPEED, DAMAGE_COEFFICIENT);
    }

    @Override
    public double getCollisionMargin() {
        return COLLISION_MARGIN;
    }
}