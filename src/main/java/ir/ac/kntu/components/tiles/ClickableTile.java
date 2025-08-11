package ir.ac.kntu.components.tiles;

import ir.ac.kntu.animations.factories.AnimationFactory;
import javafx.scene.image.ImageView;

public abstract class ClickableTile extends Tile {
    private final AnimationFactory animFactory;

    public ClickableTile(TileType tileType, AnimationFactory animFactory) {
        super(tileType);
        this.animFactory = animFactory;
    }

    @Override
    public ImageView getImageView() {
        ImageView imageView = super.getImageView();
        animFactory.getTileHoverAnimation().animate(imageView);
        return imageView;
    }
}
