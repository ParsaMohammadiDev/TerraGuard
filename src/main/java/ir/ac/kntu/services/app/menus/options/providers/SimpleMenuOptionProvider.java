package ir.ac.kntu.services.app.menus.options.providers;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.menus.options.FastTowerOption;
import ir.ac.kntu.services.app.menus.options.MenuOption;
import ir.ac.kntu.services.game.components.defenders.types.factories.DefenderTypeFactory;
import ir.ac.kntu.services.game.core.markets.Market;
import java.util.ArrayList;
import java.util.List;

public class SimpleMenuOptionProvider implements MenuOptionProvider {
    private final List<MenuOption> constructionMenuOptions = new ArrayList<MenuOption>();

    public SimpleMenuOptionProvider(DefenderTypeFactory defenderTypeFactory, Market market, AnimationFactory animFactory) {
        constructionMenuOptions.add(new FastTowerOption(defenderTypeFactory, animFactory, market));
    }

    @Override
    public List<MenuOption> getConstructionMenuOptions() {
        return constructionMenuOptions;
    }
}