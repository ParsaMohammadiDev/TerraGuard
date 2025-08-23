package ir.ac.kntu.services.game.components.tiles.states;

import ir.ac.kntu.services.game.components.tiles.ClickableTile;
import ir.ac.kntu.services.game.components.tiles.Tile;
import javafx.scene.image.ImageView;

public interface TileState {
    void setTile(ClickableTile tile);
    void executeOnClick();
    void apply(ImageView view);
}