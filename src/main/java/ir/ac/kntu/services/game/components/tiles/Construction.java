package ir.ac.kntu.services.game.components.tiles;


import ir.ac.kntu.services.app.AppServices;
import javafx.scene.image.Image;

public class Construction extends ClickableTile {
    private static final String CONSTRUCTION_PATH = "/game/components/tiles/construction.png";
    private static final Image CONSTRUCTION_IMAGE = new Image(CONSTRUCTION_PATH);

    public Construction(TileType tileType, AppServices appServices) {
        super(tileType, appServices);
    }

    @Override
    public Image getImage() {
        return CONSTRUCTION_IMAGE;
    }
}