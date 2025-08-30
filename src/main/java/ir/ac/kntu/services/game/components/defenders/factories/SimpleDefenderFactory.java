package ir.ac.kntu.services.game.components.defenders.factories;

import ir.ac.kntu.services.game.components.defenders.Defender;
import ir.ac.kntu.services.game.components.defenders.FastTower;
import ir.ac.kntu.services.game.components.defenders.PowerfulTower;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.defenders.types.FastTowerType;
import ir.ac.kntu.services.game.components.defenders.types.PowerfulTowerType;

public class SimpleDefenderFactory implements DefenderFactory {
    @Override
    public Defender getDefender(DefenderType defenderType) {
        return createDefender(defenderType);
    }

    private Defender createDefender(DefenderType defenderType) {
        if(defenderType instanceof FastTowerType)
            return new FastTower(defenderType);
        if(defenderType instanceof PowerfulTowerType)
            return new PowerfulTower(defenderType);
        else
            throw new IllegalStateException("Unsupported defenderType");
    }
}