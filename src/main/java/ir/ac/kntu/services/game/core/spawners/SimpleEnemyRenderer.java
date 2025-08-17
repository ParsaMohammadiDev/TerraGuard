package ir.ac.kntu.services.game.core.spawners;

import ir.ac.kntu.services.game.GameServices;
import ir.ac.kntu.services.game.components.enemies.Enemy;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;

public class SimpleEnemyRenderer implements EnemyRenderer {
    private final GameServices gameServices;
    private final List<Enemy> enemies = new ArrayList<>();
    private final Pane enemyPane = new Pane();

    public SimpleEnemyRenderer(GameServices gameServices) {
        this.gameServices = gameServices;
        enemyPane.setPrefSize(
                gameServices.getMapRenderer().getMapCols() * gameServices.getTileFactory().getTileSize(),
                gameServices.getMapRenderer().getMapRows() * gameServices.getTileFactory().getTileSize()
        );
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
        if (path == null || path.size() < 2) return; // no movement if path is empty or has only one point

        enemy.setPosition(path.get(0).getX(), path.get(0).getY()); // set position to start
        int[] currentIndex = {1}; // keep track of target point indexes

        AnimationTimer timer = new AnimationTimer() { // AnimationTimer Anonymous impl
            private long lastUpdate = -1; // to save last frame time to calc delta time

            @Override
            public void handle(long now) { // AnimationTimer runs handle() every frame
                if (lastUpdate < 0) {
                    lastUpdate = now; // now is in nanoseconds
                    return;
                }

                double deltaTime = (now - lastUpdate) / 1_000_000_000.0; // convert time te seconds
                lastUpdate = now;

                if (currentIndex[0] >= path.size()) { // end if enemy reached end of path
                    stop();
                    return;
                }

                Point2D currentPos = new Point2D(enemy.getX(), enemy.getY());
                Point2D target = path.get(currentIndex[0]);

                Point2D direction = target.subtract(currentPos); //direction vector
                double distance = direction.magnitude();

                if (distance < 1) { // snap to target if distance is less than 1px
                    currentIndex[0]++;
                    return;
                }

                Point2D normalized = direction.normalize(); // change length of direction vector to 1
                double moveDist = enemy.getSpeed() * deltaTime; // calc distance to move comes from speed and delta time

                if (moveDist >= distance) { // has enemy passed target?
                    enemy.setPosition(target.getX(), target.getY());
                    currentIndex[0]++; // snap it back to target if yes
                } else {
                    Point2D newPos = currentPos.add(normalized.multiply(moveDist)); // move a bit forward if no
                    enemy.setPosition(newPos.getX(), newPos.getY());
                }
            }
        };
        timer.start();
    }
}