package ir.ac.kntu.services.game.components.enemies;

import ir.ac.kntu.services.game.components.enemies.types.EnemyType;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.List;

public class Solider extends Enemy {
    private static final double DAMAGE_COEFFICIENT = 10.0;
    private static final double COLLISION_MARGIN = 30;
    private static final double RESISTANCE = 1;
    private static final double INITIAL_HEALTH = 5;

    public Solider(EnemyType type, List<Point2D> path) {
        super(type, path);
        setHealth(INITIAL_HEALTH);
    }

    @Override
    public StackPane getEnemyComposite() {
        StackPane solider = new StackPane();
        solider.getChildren().addAll(new ImageView(getEnemyType().getBaseImage()));
        return solider;
    }

    @Override
    public double getCollisionMargin() {
        return COLLISION_MARGIN;
    }

    @Override
    public double getDamageCoefficient() {
        return DAMAGE_COEFFICIENT;
    }

    @Override
    public void damage(double amount) {
        setHealth(getHealth() - amount * RESISTANCE);
    }
}