package ir.ac.kntu.services.game.components.defenders.types;

import javafx.scene.image.Image;

public class FastTowerType extends DefenderType {
    private static final String NAME = "Fast Tower";
    private static final double PRICE = 50.0;
    private static final String FAST_TOWER_PATH = "/game/components/defenders/fast_tower.png";
    private static final Image FAST_TOWER_IMAGE = new Image(FAST_TOWER_PATH);

    public FastTowerType() {
        super(NAME, PRICE);
    }

    @Override
    public Image getImage() {
        return FAST_TOWER_IMAGE;
    }
}