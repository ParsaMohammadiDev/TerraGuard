package ir.ac.kntu.components.tiles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Tile {
    private static final double TILE_SIZE = 50;

    private TileType tileType;

    public Tile(TileType tileType) {
        this.tileType = tileType;
    }

    public ImageView getImageView() {
        ImageView imageView = new ImageView(getImage());
        imageView.setFitWidth(TILE_SIZE);
        return imageView;
    }

    public abstract Image getImage();
}