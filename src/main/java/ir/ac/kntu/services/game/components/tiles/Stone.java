package ir.ac.kntu.services.game.components.tiles;

import javafx.scene.image.Image;

public class Stone extends Tile {
    private static final String STONE_PATH = "/game/components/tiles/stone.png";
    private static final Image STONE_IMAGE = new Image(STONE_PATH);

    public Stone(TileType tileType) {
        super(tileType);
    }

    @Override
    public Image getImage() {
        return STONE_IMAGE;
    }
}
