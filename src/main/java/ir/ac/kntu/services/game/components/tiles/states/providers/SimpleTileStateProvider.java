package ir.ac.kntu.services.game.components.tiles.states.providers;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.menus.factories.MenuFactory;
import ir.ac.kntu.services.game.components.defenders.Defender;
import ir.ac.kntu.services.game.components.tiles.states.Built;
import ir.ac.kntu.services.game.components.tiles.states.Clicked;
import ir.ac.kntu.services.game.components.tiles.states.Unclicked;
import ir.ac.kntu.services.game.components.tiles.states.TileState;

public class SimpleTileStateProvider implements TileStateProvider {
    private final AnimationFactory animFactory;
    private final MenuFactory menuFactory;

    public SimpleTileStateProvider(AnimationFactory animFactory, MenuFactory menuFactory) {
        this.animFactory = animFactory;
        this.menuFactory = menuFactory;
    }

    @Override
    public TileState getUnclickedTileState() {
        return new Unclicked(animFactory, menuFactory.getConstructionMenu(), this);
    }

    @Override
    public TileState getClickedTileState() {
        return new Clicked(animFactory, menuFactory.getConstructionMenu(), this);
    }

    @Override
    public TileState getBuiltState(Defender defender) {
        return new Built(defender);
    }
}