package ir.ac.kntu.services.game.components.tiles;

import javafx.scene.image.Image;

public class Grass extends Tile {
    private static final String GRASS_PATH = "/game/components/tiles/grass.png";
    private static final Image GRASS_IMAGE = new Image(GRASS_PATH);

    public Grass(TileType tileType) {
        super(tileType);
    }

    @Override
    public Image getImage() {
        return GRASS_IMAGE;
    }
}