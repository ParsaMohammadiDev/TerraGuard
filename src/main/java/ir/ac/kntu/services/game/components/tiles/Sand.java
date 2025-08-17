package ir.ac.kntu.services.game.components.tiles;

import javafx.scene.image.Image;

public class Sand extends Tile {
    private static final String SAND_PATH = "/game/components/tiles/sand.png";
    private static final Image SAND_IMAGE = new Image(SAND_PATH);

    public Sand(TileType tileType, double tileSize) {
        super(tileType, tileSize);
    }

    @Override
    public Image getImage() {
        return SAND_IMAGE;
    }
}
