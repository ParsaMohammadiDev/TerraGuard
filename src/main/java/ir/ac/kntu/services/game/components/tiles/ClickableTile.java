package ir.ac.kntu.services.game.components.tiles;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;

public abstract class ClickableTile extends Tile {
    private final AnimationFactory animFactory;

    public ClickableTile(TileType tileType, AnimationFactory animFactory, Double tileSize) {
        super(tileType, tileSize);
        this.animFactory = animFactory;
    }

    @Override
    public ImageView getImageView() {
        ImageView imageView = super.getImageView();
        animFactory.getTileHoverAnimation().animate(imageView);
        return imageView;
    }
}