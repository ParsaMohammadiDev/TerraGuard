package ir.ac.kntu.services.game.components.defenders.managers;

import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;

public interface DefenderManager {
    void plantDefender(ClickableTile tile, DefenderType defenderType);
}