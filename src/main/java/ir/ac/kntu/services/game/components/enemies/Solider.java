package ir.ac.kntu.services.game.components.enemies;

import ir.ac.kntu.services.game.components.enemies.types.EnemyType;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.List;

public class Solider extends Enemy {
    private static final double DAMAGE_COEFFICIENT = 10.0;

    public Solider(EnemyType type, List<Point2D> path) {
        super(type, path, DAMAGE_COEFFICIENT);
    }

    @Override
    public StackPane getEnemyComposite() {
        StackPane solider = new StackPane();
        solider.getChildren().addAll(new ImageView(getEnemyType().getBaseImage()));
        return solider;
    }
}