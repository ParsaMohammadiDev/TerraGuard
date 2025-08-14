package ir.ac.kntu.services.game.components.enemies;

import ir.ac.kntu.services.game.components.enemies.types.EnemyType;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.List;

public abstract class Enemy {
    private static final double VIEW_SIZE = 70;

    private EnemyType type;
    private List<Point2D> path;

    public Enemy(EnemyType type, List<Point2D> path) {
        this.type = type;
        this.path = path;
    }

    public EnemyType getEnemyType() {
        return type;
    }

    public Pane getView() {
        StackPane enemyPane = getEnemyComposite();
        enemyPane.setPrefSize(VIEW_SIZE, VIEW_SIZE);
        return enemyPane;
    }

    public abstract StackPane getEnemyComposite();
}