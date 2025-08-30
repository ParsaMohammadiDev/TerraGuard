package ir.ac.kntu.services.game.components.defenders.factories;

import ir.ac.kntu.services.game.components.defenders.Defender;
import ir.ac.kntu.services.game.components.defenders.FastTower;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.defenders.types.FastTowerType;

public class SimpleDefenderFactory implements DefenderFactory {
    @Override
    public Defender getDefender(DefenderType defenderType) {
        return createDefender(defenderType);
    }

    private Defender createDefender(DefenderType defenderType) {
        if(defenderType instanceof FastTowerType)
            return new FastTower(defenderType);
        else
            throw new IllegalStateException("Unsupported defenderType");
    }
}