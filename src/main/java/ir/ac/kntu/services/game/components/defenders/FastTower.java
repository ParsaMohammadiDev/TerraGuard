package ir.ac.kntu.services.game.components.defenders;

import ir.ac.kntu.services.game.components.Shooter;
import ir.ac.kntu.services.game.components.bullets.BulletType;
import ir.ac.kntu.services.game.components.bullets.managers.BulletManager;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;
import ir.ac.kntu.services.game.core.strategies.EnemySelector;
import ir.ac.kntu.services.game.core.strategies.OldEnemySelector;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FastTower extends Defender implements Shooter {
    private static final double DAMAGE_COEFFICIENT = 5.0;
    private static final double MUZZLE_LENGTH = 40.0; // in pixels
    private static final long SHOOTING_DELAY = 1;

    private final BulletType bulletType = BulletType.FAST_BULLET;
    private final EnemySelector enemySelector = new OldEnemySelector();

    private final BulletManager bulletManager;

    private ScheduledExecutorService enemyTracker;

    public FastTower(DefenderType defenderType, BulletManager bulletManager, ClickableTile tile) {
        super(defenderType, DAMAGE_COEFFICIENT, tile);
        this.bulletManager = bulletManager;
    }

    @Override
    public Pane getDefenderComposite() {
        Pane fastTowerPane = new Pane();
        fastTowerPane.getChildren().add(new ImageView(getDefenderType().getImage()));
        return fastTowerPane;
    }

    @Override
    public void activate(List<Enemy> enemies) {
        if (enemyTracker == null || enemyTracker.isShutdown()) {
            enemyTracker = Executors.newSingleThreadScheduledExecutor();
            enemyTracker.scheduleWithFixedDelay(() -> {
                if (enemies != null && !enemies.isEmpty()) {
                    Platform.runLater(() -> {
                        bulletManager.shoot(this, enemySelector.selectEnemy(enemies, this));
                    });
                }
            }, 0, SHOOTING_DELAY, TimeUnit.SECONDS);
        }
    }

    @Override
    public BulletType getBulletType() {
        return bulletType;
    }

    @Override
    public Point2D getMuzzlePosition() {
        double x = getView().getLayoutX();
        double y = getView().getLayoutY();
        double rotation = getView().getRotate() + 90;
        double muzzleX = x + (MUZZLE_LENGTH * Math.cos(Math.toRadians(rotation)));
        double muzzleY = y + (MUZZLE_LENGTH * Math.sin(Math.toRadians(rotation)));
        return new Point2D(muzzleX, muzzleY);
    }
}
