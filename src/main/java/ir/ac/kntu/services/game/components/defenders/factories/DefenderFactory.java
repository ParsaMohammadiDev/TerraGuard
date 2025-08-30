package ir.ac.kntu.services.game.components.defenders.factories;

import ir.ac.kntu.services.game.components.defenders.Defender;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;

public interface DefenderFactory {
    public Defender getDefender(DefenderType defenderType);
}