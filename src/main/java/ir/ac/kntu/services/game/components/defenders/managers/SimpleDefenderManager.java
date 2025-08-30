package ir.ac.kntu.services.game.components.defenders.managers;

import ir.ac.kntu.services.game.components.defenders.factories.DefenderFactory;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;
import ir.ac.kntu.services.game.components.tiles.states.providers.TileStateProvider;

public class SimpleDefenderManager implements DefenderManager {
    private final TileStateProvider stateProvider;
    private final DefenderFactory defenderFactory;

    public SimpleDefenderManager(TileStateProvider stateProvider, DefenderFactory defenderFactory) {
        this.stateProvider = stateProvider;
        this.defenderFactory = defenderFactory;
    }

    @Override
    public void plantDefender(ClickableTile tile, DefenderType defenderType) {
        tile.setState(stateProvider.getBuiltState(defenderFactory.getDefender(defenderType)));
    }
}