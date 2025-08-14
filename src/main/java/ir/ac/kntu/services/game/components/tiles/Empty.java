package ir.ac.kntu.services.game.components.tiles;

import javafx.scene.image.Image;

public class Empty extends Tile {
    private static final String EMPTY_PATH = "/game/components/tiles/empty.png";
    private static final Image EMPTY_IMAGE = new Image(EMPTY_PATH);

    public Empty(TileType type) {
        super(type);
    }

    @Override
    public Image getImage() {
        return EMPTY_IMAGE;
    }
}
