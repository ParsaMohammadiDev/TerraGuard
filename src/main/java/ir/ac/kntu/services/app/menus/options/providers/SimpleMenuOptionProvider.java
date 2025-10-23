package ir.ac.kntu.services.app.menus.options.providers;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.menus.options.ConstructionOption;
import ir.ac.kntu.services.app.menus.options.FastTowerOption;
import ir.ac.kntu.services.app.menus.options.PowerfulTowerOption;
import ir.ac.kntu.services.game.core.managers.DefenderManager;
import ir.ac.kntu.services.game.components.defenders.types.factories.DefenderTypeFactory;
import ir.ac.kntu.services.game.core.markets.Market;
import java.util.ArrayList;
import java.util.List;

public class SimpleMenuOptionProvider implements MenuOptionProvider {
    private final List<ConstructionOption> constructionMenuOptions = new ArrayList<>();

    public SimpleMenuOptionProvider(DefenderTypeFactory defenderTypeFactory, Market market, AnimationFactory animFactory, DefenderManager defenderManager) {
        constructionMenuOptions.add(new FastTowerOption(defenderTypeFactory, animFactory, market, defenderManager));
        constructionMenuOptions.add(new PowerfulTowerOption(defenderTypeFactory, animFactory, market, defenderManager));
    }

    @Override
    public List<ConstructionOption> getConstructionMenuOptions() {
        return constructionMenuOptions;
    }
}