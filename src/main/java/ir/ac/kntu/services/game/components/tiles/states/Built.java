package ir.ac.kntu.services.game.components.tiles.states;

import ir.ac.kntu.services.game.components.defenders.Defender;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;
import javafx.scene.layout.Pane;

public class Built implements TileState {
    private final Defender defender;

    private ClickableTile tile;

    public Built(Defender defender) {
        this.defender = defender;
    }

    @Override
    public void setTile(ClickableTile tile) {
        this.tile = tile;
    }

    @Override
    public void executeOnClick() {

    }

    @Override
    public void apply(Pane view) {
        view.getChildren().removeFirst();
        view.getChildren().add(defender.getView());
    }
}