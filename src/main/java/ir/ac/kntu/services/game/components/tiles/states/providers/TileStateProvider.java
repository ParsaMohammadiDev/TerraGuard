package ir.ac.kntu.services.game.components.tiles.states.providers;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.game.components.defenders.Defender;
import ir.ac.kntu.services.game.components.tiles.states.TileState;

public interface TileStateProvider {
    TileState getUnclickedTileState();
    TileState getClickedTileState();
    TileState getBuiltState(Defender defender);
}