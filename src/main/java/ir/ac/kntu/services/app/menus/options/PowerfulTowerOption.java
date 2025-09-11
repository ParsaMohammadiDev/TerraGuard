package ir.ac.kntu.services.app.menus.options;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.game.core.managers.DefenderManager;
import ir.ac.kntu.services.game.components.defenders.types.factories.DefenderTypeFactory;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;
import ir.ac.kntu.services.game.core.markets.Market;

public class PowerfulTowerOption extends ConstructionOption {
    private final DefenderManager defenderManager;

    public PowerfulTowerOption(DefenderTypeFactory defenderTypeFactory, AnimationFactory animFactory, Market market, DefenderManager defenderManager) {
        super(defenderTypeFactory.getPowerfulTowerType(), animFactory, market);
        this.defenderManager = defenderManager;
    }

    @Override
    public void executeOnAction() {
        getMarket().purchase(getDefenderType());
        defenderManager.plantDefender((ClickableTile) getMenu().getInvoker(), getDefenderType());
        getMenu().hide();
    }
}
