package ir.ac.kntu.services.game.components.enemies;

import ir.ac.kntu.services.game.EnemyServices;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Solider extends Enemy {
    public Solider(EnemyServices enemyServices) {
        super(enemyServices.getEnemyTypeFactory().getSoliderType());
    }

    @Override
    public StackPane getEnemyComposite() {
        StackPane solider = new StackPane();
        solider.getChildren().addAll(new ImageView(getEnemyType().getBaseImage()));
        return solider;
    }
}