package ir.ac.kntu.services.game.core.spawners;

import ir.ac.kntu.services.game.GameServices;
import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.components.tiles.Tile;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;

public class SimpleEnemyRenderer implements EnemyRenderer {
    private static final double ENEMY_SPEED_SEED = 30;
    private static final int rows = 7;
    private static final int cols = 9;

    private GameServices gameServices;
    private List<Enemy> enemies = new ArrayList<>();
    private double enemySpeed = 0;

    public SimpleEnemyRenderer(GameServices gameServices) {
        this.gameServices = gameServices;
        enemySpeed = gameServices.getGameEngine().getGameDifficulty().getDifficultyCoefficient() * ENEMY_SPEED_SEED;
    }

    @Override
    public Pane renderEnemies() {
        Pane enemyPane = new Pane();
        for (Enemy enemy : enemies) {
            moveEnemy(enemy);
            enemyPane.getChildren().add(enemy.getView());
        }
        enemyPane.setPrefSize(cols * Tile.getTileSize(), rows * Tile.getTileSize());
        return enemyPane;
    }

    @Override
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    private void moveEnemy(Enemy enemy) {
        List<Point2D> path = enemy.getPath();
        if (path == null || path.size() < 2) return;

        // start at first point
        enemy.setPosition(path.get(0).getX(), path.get(0).getY());

        final int[] currentIndex = {1};

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
                double moveDist = enemySpeed * deltaTime;

                if (moveDist >= distance) {
                    enemy.setPosition(target.getX(), target.getY());
                    currentIndex[0]++;
                } else {
                    Point2D newPos = currentPos.add(normalized.multiply(moveDist));
                    enemy.setPosition(newPos.getX(), newPos.getY());
                }
            }
        };
        timer.start();
    }
}