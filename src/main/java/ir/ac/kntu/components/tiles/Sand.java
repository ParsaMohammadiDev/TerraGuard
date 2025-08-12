package ir.ac.kntu.components.tiles;

import javafx.scene.image.Image;

public class Sand extends Tile {
    private static final String SAND_PATH = "/game/components/tiles/sand.png";
    private static final Image SAND_IMAGE = new Image(SAND_PATH);

    public Sand(TileType tileType) {
        super(tileType);
    }

    @Override
    public Image getImage() {
        return SAND_IMAGE;
    }
}
