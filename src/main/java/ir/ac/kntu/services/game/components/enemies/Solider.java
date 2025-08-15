package ir.ac.kntu.services.game.components.enemies;

import ir.ac.kntu.services.game.EnemyServices;
import ir.ac.kntu.services.game.GameServices;
import ir.ac.kntu.services.game.components.enemies.types.EnemyType;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.List;

public class Solider extends Enemy {
    public Solider(EnemyType type, List<Point2D> path) {
        super(type, path);
    }

    @Override
    public StackPane getEnemyComposite() {
        StackPane solider = new StackPane();
        solider.getChildren().addAll(new ImageView(getEnemyType().getBaseImage()));
        return solider;
    }
}