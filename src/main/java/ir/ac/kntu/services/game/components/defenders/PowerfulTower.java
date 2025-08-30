package ir.ac.kntu.services.game.components.defenders;

import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PowerfulTower extends Defender {
    public PowerfulTower(DefenderType defenderType) {
        super(defenderType);
    }

    @Override
    public Pane getDefenderComposite() {
        Pane powerfulTower = new Pane();
        powerfulTower.getChildren().add(new ImageView(getDefenderType().getImage()));
        return powerfulTower;
    }
}
