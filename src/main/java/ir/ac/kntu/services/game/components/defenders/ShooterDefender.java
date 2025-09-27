package ir.ac.kntu.services.game.components.defenders;

import ir.ac.kntu.services.game.components.Shooter;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;
import ir.ac.kntu.services.game.core.managers.BulletManager;
import ir.ac.kntu.services.game.core.strategies.EnemySelector;
import javafx.application.Platform;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class ShooterDefender extends Defender implements Shooter {
    private final BulletManager bulletManager;
    private final EnemySelector enemySelector;
    private final long shooting_delay;

    private ScheduledExecutorService enemyTracker;

    public ShooterDefender(DefenderType defenderType,
                           double damageCoefficient,
                           ClickableTile tile,
                           BulletManager bulletManager,
                           EnemySelector enemySelector,
                           long shooting_delay) {
        super(defenderType, damageCoefficient, tile);
        this.shooting_delay = shooting_delay;
        this.bulletManager = bulletManager;
        this.enemySelector = enemySelector;
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
            }, 0, shooting_delay, TimeUnit.SECONDS);
        }
    }

    @Override
    public void deactivate() {
        if (enemyTracker != null && !enemyTracker.isShutdown()) {
            enemyTracker.shutdown();
            try {
                if (!enemyTracker.awaitTermination(5, TimeUnit.SECONDS)) {
                    enemyTracker.shutdownNow();
                }
            } catch (InterruptedException e) {
                enemyTracker.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}