package ir.ac.kntu.services.game.components.defenders.factories;

import ir.ac.kntu.services.game.components.defenders.Defender;
import ir.ac.kntu.services.game.components.defenders.FastTower;
import ir.ac.kntu.services.game.components.defenders.types.factories.DefenderTypeFactory;

public class SimpleDefenderFactory implements DefenderFactory {
    private final DefenderTypeFactory defenderTypeFactory;

    public SimpleDefenderFactory(DefenderTypeFactory defenderTypeFactory) {
        this.defenderTypeFactory = defenderTypeFactory;
    }

    @Override
    public Defender getFastTower() {
        return new FastTower(defenderTypeFactory.getFastTowerType());
    }
}