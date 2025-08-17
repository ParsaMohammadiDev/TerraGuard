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
    private double x;
    private double y;
    private StackPane enemyView;

    public Enemy(EnemyType type, List<Point2D> path) {
        this.type = type;
        this.path = path;
        enemyView = getEnemyComposite();
        enemyView.setPrefSize(VIEW_SIZE, VIEW_SIZE);
    }

    public EnemyType getEnemyType() {
        return type;
    }

    public Pane getView() {
        return enemyView;
    }
    public List<Point2D> getPath() {
        return path;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
        Pane view = getView();
        view.relocate(x, y); // <-- actually move the JavaFX node
    }

    public abstract StackPane getEnemyComposite();
}