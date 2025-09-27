package ir.ac.kntu.services.game.components.bullets;

public class NormalBullet extends Bullet {
    private static final double SPEED = 5.0;

    public NormalBullet() {
        super(BulletType.NORMAL_BULLET, SPEED);
    }
}