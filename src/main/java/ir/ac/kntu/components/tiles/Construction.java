package ir.ac.kntu.components.tiles;


import ir.ac.kntu.animations.factories.AnimationFactory;
import javafx.scene.image.Image;

public class Construction extends ClickableTile {
    private static final String CONSTRUCTION_PATH = "/game/components/tiles/construction.png";
    private static final Image CONSTRUCTION_IMAGE = new Image(CONSTRUCTION_PATH);

    public Construction(TileType tileType, AnimationFactory animFactory) {
        super(tileType, animFactory);
    }

    @Override
    public Image getImage() {
        return CONSTRUCTION_IMAGE;
    }
}