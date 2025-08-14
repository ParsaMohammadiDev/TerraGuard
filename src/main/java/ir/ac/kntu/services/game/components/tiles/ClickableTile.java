package ir.ac.kntu.services.game.components.tiles;

import ir.ac.kntu.services.app.AppServices;
import javafx.scene.image.ImageView;

public abstract class ClickableTile extends Tile {
    private final AppServices appServices;

    public ClickableTile(TileType tileType, AppServices appServices) {
        super(tileType);
        this.appServices = appServices;
    }

    @Override
    public ImageView getImageView() {
        ImageView imageView = super.getImageView();
        appServices.getAnimationFactory().getTileHoverAnimation().animate(imageView);
        return imageView;
    }
}
