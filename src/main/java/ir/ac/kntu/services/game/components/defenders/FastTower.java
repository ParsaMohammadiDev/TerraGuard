package ir.ac.kntu.services.game.components.defenders;

import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class FastTower extends Defender {
    public FastTower(DefenderType defenderType) {
        super(defenderType);
    }

    @Override
    public Pane getDefenderComposite() {
        Pane fastTowerPane = new Pane();
        fastTowerPane.getChildren().add(new ImageView(getDefenderType().getImage()));
        return fastTowerPane;
    }
}
