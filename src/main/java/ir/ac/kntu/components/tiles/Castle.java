package ir.ac.kntu.components.tiles;

import javafx.scene.image.Image;

public class Castle extends Tile {
    private static final String CASTLE_PATH = "/game/components/tiles/castle.png";
    private static final Image CASTLE_IMAGE = new Image(CASTLE_PATH);

    public Castle(TileType tileType) {
        super(tileType);
    }

    @Override
    public Image getImage() {
        return CASTLE_IMAGE;
    }
}