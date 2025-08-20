package ir.ac.kntu.services.app.menus.options;

import ir.ac.kntu.services.game.components.defenders.types.factories.DefenderTypeFactory;

public class FastTowerOption extends ConstructionOption {

    public FastTowerOption(DefenderTypeFactory defenderTypeFactory) {
        super(defenderTypeFactory.getFastTowerType().getName(), String.valueOf((int) defenderTypeFactory.getFastTowerType().getPrice()), defenderTypeFactory.getFastTowerType().getImage());
    }
}