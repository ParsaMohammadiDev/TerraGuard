package ir.ac.kntu.services.game.components.defenders.types.factories;

import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.defenders.types.FastTowerType;
import java.util.HashMap;
import java.util.Map;

public class FlyWeightDefenderTypeFactory implements DefenderTypeFactory {
    private final Map<String, DefenderType> defenderTypes = new HashMap<>();

    @Override
    public DefenderType getFastTowerType() {
        return defenderTypes.computeIfAbsent("fast_tower", this::createDefenderType);
    }

    private DefenderType createDefenderType(String name) {
        return switch (name) {
            case "fast_tower" -> new FastTowerType();
            default -> throw new IllegalStateException("Invalid DefenderType request");
        };
    }
}