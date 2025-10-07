package ir.ac.kntu.services.game.core.renderers;

import ir.ac.kntu.services.game.components.Entity;
import ir.ac.kntu.services.game.components.Shooter;
import ir.ac.kntu.services.game.components.bullets.Bullet;
import ir.ac.kntu.services.game.core.managers.CollisionManager;
import javafx.animation.AnimationTimer;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;

public class SimpleBulletRenderer implements BulletRenderer {
    private final List<AnimationTimer> timers = new ArrayList<>();
    private final List<Bullet> renderingBullets = new ArrayList<>();
    private final EffectRenderer effectRenderer;
    private final CollisionManager collisionManager;

    private boolean isPause = false;

    public SimpleBulletRenderer(EffectRenderer effectRenderer, CollisionManager collisionManager) {
        this.effectRenderer = effectRenderer;
        this.collisionManager = collisionManager;
    }

    @Override
    public void renderBullet(Bullet bullet, Shooter shooter, Entity target, Pane gamePane) {
        renderingBullets.add(bullet);
        Point2D shootingPoint = shooter.getMuzzlePosition();
        Point2D targetPosition = new Point2D(target.getView().getLayoutX(), target.getView().getLayoutY());
        bullet.setPosition(shootingPoint.getX(), shootingPoint.getY());

        double dx = targetPosition.getX() - shootingPoint.getX();
        double dy = targetPosition.getY() - shootingPoint.getY();

        double length = Math.sqrt(dx * dx + dy * dy);
        double dirX = dx / length;
        double dirY = dy / length;

        double speed = bullet.getSpeed();
        double angle = Math.toDegrees(Math.atan2(dy, dx));
        bullet.getView().setRotate(angle - 90);

        effectRenderer.rotateMuzzle(shooter, angle - 270);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (isPause) return;

                bullet.setPosition(
                        bullet.getView().getLayoutX() + dirX * speed,
                        bullet.getView().getLayoutY() + dirY * speed
                );

                if (collisionManager.isCollidedWithPaneBounds(bullet, gamePane) ||
                collisionManager.isCollided(bullet)) {
                    this.stop();
                    terminateBullet(bullet);
                }
            }
        };
        timers.add(timer);
        timer.start();
    }

    private void terminateBullet(Bullet bullet) {
        bullet.getView().setVisible(false);
        var pane = bullet.getView().getParent();
        if (pane instanceof Pane bulletsPane) {
            bulletsPane.getChildren().remove(bullet.getView());
        }
        renderingBullets.remove(bullet);
    }

    @Override
    public void reset() {
        isPause = false;
        for (AnimationTimer timer : timers) {
            timer.stop();
        }
        for (Bullet bullet : new ArrayList<>(renderingBullets)) {
            terminateBullet(bullet);
        }
        renderingBullets.clear();
        timers.clear();
    }

    @Override
    public void pause() {
        isPause = true;
    }

    @Override
    public void resume() {
        isPause = false;
    }
}