package ir.ac.kntu.services.game.components.tiles;

import javafx.scene.image.Image;

public class Rock extends Tile {
    private static final String ROCK_PATH = "/game/components/tiles/rock.png";
    private static final Image ROCK_IMAGE = new Image(ROCK_PATH);

    public Rock(TileType tileType, double tileSize) {
        super(tileType, tileSize);
    }

    @Override
    public Image getImage() {
        return ROCK_IMAGE;
    }
}