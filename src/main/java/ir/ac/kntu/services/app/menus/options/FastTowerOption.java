package ir.ac.kntu.services.app.menus.options;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.game.components.defenders.types.factories.DefenderTypeFactory;
import ir.ac.kntu.services.game.core.markets.Market;

public class FastTowerOption extends ConstructionOption {

    public FastTowerOption(DefenderTypeFactory defenderTypeFactory, AnimationFactory animFactory, Market market) {
        super(defenderTypeFactory.getFastTowerType(), animFactory, market);
    }
}