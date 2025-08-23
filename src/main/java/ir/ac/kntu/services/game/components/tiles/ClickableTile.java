package ir.ac.kntu.services.game.components.tiles;

import ir.ac.kntu.services.game.components.tiles.states.TileState;
import javafx.scene.image.ImageView;

public abstract class ClickableTile extends Tile {
    private TileState state;
    private final ImageView view;

    public ClickableTile(TileType tileType, Double tileSize, TileState state) {
        super(tileType, tileSize);
        this.state = state;
        this.view = new ImageView(getImage());
        setState(state);
        state.setTile(this);
        view.setOnMouseClicked(e -> executeOnClick());
    }

    public void setState(TileState state) {
        this.state = state;
        state.setTile(this);
        state.apply(view);
    }

    private void executeOnClick() {
        state.executeOnClick();
        state.apply(view);
    }

    @Override
    public ImageView getView() {
        return view;
    }
}