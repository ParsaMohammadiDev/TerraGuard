package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.game.components.defenders.Defender;
import ir.ac.kntu.services.game.components.defenders.factories.DefenderFactory;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;
import ir.ac.kntu.services.game.components.tiles.states.providers.TileStateProvider;
import java.util.ArrayList;
import java.util.List;

public class SimpleDefenderManager implements DefenderManager {
    private final TileStateProvider stateProvider;
    private final DefenderFactory defenderFactory;

    private List<Defender> defenders;

    public SimpleDefenderManager(TileStateProvider stateProvider, DefenderFactory defenderFactory) {
        this.stateProvider = stateProvider;
        this.defenderFactory = defenderFactory;
        defenders = new ArrayList<Defender>();
    }

    @Override
    public void plantDefender(ClickableTile tile, DefenderType defenderType) {
        Defender defender = defenderFactory.getDefender(defenderType, tile);
        tile.setState(stateProvider.getBuiltState(defender));
        defender.activate();
        defenders.add(defender);
    }

    @Override
    public void reset() {
        for (Defender defender : defenders) {
            defender.deactivate();
        }
    }
}