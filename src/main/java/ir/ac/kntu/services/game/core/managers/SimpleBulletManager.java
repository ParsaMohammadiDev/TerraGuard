package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.game.components.Entity;
import ir.ac.kntu.services.game.components.Shooter;
import ir.ac.kntu.services.game.components.bullets.Bullet;
import ir.ac.kntu.services.game.components.bullets.factories.BulletFactory;
import ir.ac.kntu.services.game.core.renderers.BulletRenderer;
import javafx.scene.layout.Pane;

public class SimpleBulletManager implements BulletManager {
    private final BulletFactory bulletFactory;
    private final BulletRenderer bulletRenderer;

    private final Pane bulletsPane = new Pane();

    public SimpleBulletManager(BulletFactory bulletFactory, BulletRenderer bulletRenderer) {
        this.bulletFactory = bulletFactory;
        this.bulletRenderer = bulletRenderer;
    }

    @Override
    public Pane renderBullets() {
        return bulletsPane;
    }

    @Override
    public void shoot(Shooter shooter, Entity target) {
        Bullet bullet = bulletFactory.getBullet(shooter.getBulletType());
        bulletsPane.getChildren().add(bullet.getView());
        bulletRenderer.renderBullet(bullet, shooter, target, bulletsPane);
    }

    @Override
    public void reset() {
        bulletRenderer.reset();
        bulletsPane.getChildren().clear();
    }

    @Override
    public void pause() {
        bulletRenderer.pause();
    }

    @Override
    public void resume() {
        bulletRenderer.resume();
    }
}