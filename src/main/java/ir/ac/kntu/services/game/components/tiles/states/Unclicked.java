package ir.ac.kntu.services.game.components.tiles.states;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.menus.Menu;
import ir.ac.kntu.services.app.menus.factories.MenuFactory;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;
import ir.ac.kntu.services.game.components.tiles.states.providers.TileStateProvider;
import javafx.scene.image.ImageView;

public class Unclicked implements TileState {
    private final AnimationFactory animFactory;
    private final TileStateProvider stateProvider;
    private final Menu menu;

    private ClickableTile tile;

    public Unclicked(AnimationFactory animFactory, MenuFactory menuFactory, TileStateProvider stateProvider) {
        this.animFactory = animFactory;
        this.stateProvider = stateProvider;
        this.menu = menuFactory.getConstructionMenu();
    }

    @Override
    public void setTile(ClickableTile tile) {
        this.tile = tile;
    }

    @Override
    public void apply(ImageView view) {
        animFactory.getTileHoverAnimation().animate(view);
    }

    @Override
    public void executeOnClick() {
        menu.show();
        tile.setState(stateProvider.getClickedTileState());
        animFactory.getKillerAnimation().animate(tile.getView());
    }
}