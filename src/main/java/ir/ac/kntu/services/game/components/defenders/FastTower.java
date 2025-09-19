package ir.ac.kntu.services.game.components.defenders;

import ir.ac.kntu.services.game.components.Shooter;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.enemies.Enemy;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.List;

public class FastTower extends Defender implements Shooter {
    private static final double DAMAGE_COEFFICIENT = 5.0;

    public FastTower(DefenderType defenderType) {
        super(defenderType, DAMAGE_COEFFICIENT);
    }

    @Override
    public Pane getDefenderComposite() {
        Pane fastTowerPane = new Pane();
        fastTowerPane.getChildren().add(new ImageView(getDefenderType().getImage()));
        return fastTowerPane;
    }

    @Override
    public void activate(List<Enemy> enemies) {
        // logic
    }
}
