package ir.ac.kntu.services.game.core.renderers;

import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.components.maps.renderers.MapRenderer;
import ir.ac.kntu.services.game.components.tiles.factories.TileFactory;
import ir.ac.kntu.services.game.core.managers.EnemyManager;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;

public class SimpleEnemyRenderer implements EnemyRenderer {
    private final List<AnimationTimer> timers = new ArrayList<>();
    private final Pane enemyPane = new Pane();
    private List<Enemy> enemies;
    private EnemyManager enemyManager;

    public SimpleEnemyRenderer(MapRenderer mapRenderer, TileFactory tileFactory) {
        enemyPane.setPrefSize(
                mapRenderer.getMapCols() * tileFactory.getTileSize(),
                mapRenderer.getMapRows() * tileFactory.getTileSize()
        );
    }

    @Override
    public void setEnemyManager(EnemyManager enemyManager) {
        this.enemyManager = enemyManager;
        enemies = enemyManager.getEnemies();
    }

    @Override
    public Pane renderEnemies() {
        return enemyPane;
    }

    @Override
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
        enemyPane.getChildren().add(enemy.getView());
        moveEnemy(enemy);
    }

    private void moveEnemy(Enemy enemy) {
        List<Point2D> path = enemy.getPath();
        if (path == null || path.size() < 2) return;

        enemy.setPosition(path.getFirst().getX(), path.getFirst().getY());
        int[] currentIndex = {1};

        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = -1;

            @Override
            public void handle(long now) {
                if (lastUpdate < 0) {
                    lastUpdate = now;
                    return;
                }

                double deltaTime = (now - lastUpdate) / 1_000_000_000.0;
                lastUpdate = now;

                if (currentIndex[0] >= path.size()) {
                    stop();
                    timers.remove(this);
                    enemy.getView().setVisible(false);
                    enemies.remove(enemy);
                    enemyManager.reachEnemy();
                    return;
                }

                Point2D currentPos = new Point2D(enemy.getX(), enemy.getY());
                Point2D target = path.get(currentIndex[0]);

                Point2D direction = target.subtract(currentPos);
                double distance = direction.magnitude();

                if (distance < 1) {
                    currentIndex[0]++;
                    return;
                }

                Point2D normalized = direction.normalize();
                double moveDist = enemy.getSpeed() * deltaTime;

                if (moveDist >= distance) {
                    enemy.setPosition(target.getX(), target.getY());
                    currentIndex[0]++;
                } else {
                    Point2D newPos = currentPos.add(normalized.multiply(moveDist));
                    enemy.setPosition(newPos.getX(), newPos.getY());
                }
            }
        };

        timers.add(timer);
        timer.start();
    }

    @Override
    public void reset() {
        for (Enemy enemy : enemies) {
            enemy.getView().setVisible(false);
        }
        enemies.clear();
        for (AnimationTimer t : timers) {
            t.stop();
        }
        timers.clear();
    }
}