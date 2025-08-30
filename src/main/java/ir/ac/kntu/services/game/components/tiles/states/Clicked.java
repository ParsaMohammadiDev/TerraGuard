package ir.ac.kntu.services.game.components.tiles.states;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.menus.Menu;
import ir.ac.kntu.services.app.menus.factories.MenuFactory;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;
import ir.ac.kntu.services.game.components.tiles.states.providers.TileStateProvider;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Clicked implements TileState {
    private final TileStateProvider stateProvider;
    private final AnimationFactory animFactory;
    private final Menu menu;

    private ClickableTile tile;

    public Clicked(AnimationFactory animFactory, MenuFactory menuFactory, TileStateProvider stateProvider) {
        this.menu = menuFactory.getConstructionMenu();
        this.stateProvider = stateProvider;
        this.animFactory = animFactory;
    }

    @Override
    public void setTile(ClickableTile tile) {
        this.tile = tile;
    }

    @Override
    public void apply(Node view) {
        animFactory.getKillerAnimation().animate(view);
    }

    @Override
    public void executeOnClick() {
        menu.hide();
        tile.setState(stateProvider.getUnclickedTileState());
        animFactory.getKillerAnimation().animate(tile.getView());
    }
}