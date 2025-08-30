package ir.ac.kntu.services.game.core.markets;

import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import javafx.beans.property.BooleanProperty;

public interface Market {
    BooleanProperty isAffordable(DefenderType defenderType);
    boolean purchase(DefenderType defenderType);
}