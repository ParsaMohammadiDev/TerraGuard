package ir.ac.kntu.services.game.components.enemies;

import ir.ac.kntu.services.game.components.Collidable;
import ir.ac.kntu.services.game.components.Entity;
import ir.ac.kntu.services.game.components.enemies.types.EnemyType;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import java.util.List;

public abstract class Enemy implements Entity, Collidable {
    private static final double VIEW_SIZE = 70;

    private EnemyType type;
    private List<Point2D> path;
    private double x;
    private double y;
    private double speed;
    private double health;
    private StackPane enemyView;
    private double resistance;

    public Enemy(EnemyType type, List<Point2D> path, double resistance) {
        this.type = type;
        this.path = path;
        this.resistance = resistance;
        enemyView = getEnemyComposite();
        enemyView.setPrefSize(VIEW_SIZE, VIEW_SIZE);
    }

    public double getResistance() {
        return resistance;
    }

    public EnemyType getEnemyType() {
        return type;
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

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
        enemyView.relocate(x, y);
    }

    protected void setHealth(double health) {
        this.health = health;
    }

    public abstract StackPane getEnemyComposite();

    public abstract double getDamageCoefficient();

    @Override
    public Pane getView() {
        return enemyView;
    }

    @Override
    public double getHealth() {
        return health;
    }
}