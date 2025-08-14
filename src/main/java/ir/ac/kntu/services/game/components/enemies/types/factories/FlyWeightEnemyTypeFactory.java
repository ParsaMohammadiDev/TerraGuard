package ir.ac.kntu.services.game.components.enemies.types.factories;

import ir.ac.kntu.services.game.components.enemies.types.EnemyType;
import ir.ac.kntu.services.game.components.enemies.types.SoliderType;
import java.util.HashMap;
import java.util.Map;


public class FlyWeightEnemyTypeFactory implements EnemyTypeFactory {
    private Map<String, EnemyType> types = new HashMap<>();

    @Override
    public EnemyType getSoliderType() {
        return types.computeIfAbsent("solider", this::createEnemyType);
    }

    private EnemyType createEnemyType(String type) {
        return switch (type) {
            case "solider" -> new SoliderType();
            default -> throw new IllegalStateException("Invalid EnemyType request");
        };
    }
}