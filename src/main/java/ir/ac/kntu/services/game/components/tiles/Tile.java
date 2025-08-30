package ir.ac.kntu.services.game.components.tiles;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Tile {
    private TileType tileType;
    private double tileSize;

    public Tile(TileType tileType, double tileSize) {
        this.tileType = tileType;
        this.tileSize = tileSize;
    }

    public Node getView() {
        ImageView imageView = new ImageView(getImage());
        imageView.setFitWidth(tileSize);
        imageView.setFitHeight(tileSize);
        return imageView;
    }

    public abstract Image getImage();
}