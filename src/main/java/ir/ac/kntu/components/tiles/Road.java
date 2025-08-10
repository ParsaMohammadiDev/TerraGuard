package ir.ac.kntu.components.tiles;

import javafx.scene.image.Image;

public class Road extends Tile {
    private static final String ROAD_PATH = "/game/components/tiles/road.png";
    private static final Image ROAD_IMAGE = new Image(ROAD_PATH);

    public Road(TileType tileType) {
        super(tileType);
    }

    @Override
    public Image getImage() {
        return ROAD_IMAGE;
    }
}