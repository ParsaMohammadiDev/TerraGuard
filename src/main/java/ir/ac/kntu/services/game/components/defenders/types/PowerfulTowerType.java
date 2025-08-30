package ir.ac.kntu.services.game.components.defenders.types;

import javafx.scene.image.Image;

public class PowerfulTowerType extends DefenderType {
    private static final String NAME = "Powerful Tower";
    private static final double PRICE = 60.0;
    private static final String POWERFUL_TOWER_PATH = "/game/components/defenders/powerful_tower.png";
    private static final Image POWERFUL_TOWER_IMAGE = new Image(POWERFUL_TOWER_PATH);

    public PowerfulTowerType() {
        super(NAME, PRICE);
    }

    @Override
    public Image getImage() {
        return POWERFUL_TOWER_IMAGE;
    }
}
