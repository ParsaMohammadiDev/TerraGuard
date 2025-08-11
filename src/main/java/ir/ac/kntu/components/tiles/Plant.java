package ir.ac.kntu.components.tiles;

import javafx.scene.image.Image;

public class Plant extends Tile {
    private static final String PLANT_PATH = "/game/components/tiles/plant.png";
    private static final Image Plant_Image = new Image(PLANT_PATH);

    public Plant(TileType type) {
        super(type);
    }

    @Override
    public Image getImage() {
        return Plant_Image;
    }
}
