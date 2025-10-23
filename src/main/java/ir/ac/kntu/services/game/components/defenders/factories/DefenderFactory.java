package ir.ac.kntu.services.game.components.defenders.factories;

import ir.ac.kntu.services.game.components.defenders.Defender;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;

public interface DefenderFactory {
    Defender getDefender(DefenderType defenderType, ClickableTile tile);
}