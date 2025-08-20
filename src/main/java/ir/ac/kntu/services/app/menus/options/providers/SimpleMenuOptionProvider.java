package ir.ac.kntu.services.app.menus.options.providers;

import ir.ac.kntu.services.app.menus.options.FastTowerOption;
import ir.ac.kntu.services.app.menus.options.MenuOption;
import ir.ac.kntu.services.game.components.defenders.types.factories.DefenderTypeFactory;

import java.util.ArrayList;
import java.util.List;

public class SimpleMenuOptionProvider implements MenuOptionProvider {
    private final List<MenuOption> constructionMenuOptions = new ArrayList<MenuOption>();

    public SimpleMenuOptionProvider(DefenderTypeFactory defenderTypeFactory) {
        constructionMenuOptions.add(new FastTowerOption(defenderTypeFactory));
        constructionMenuOptions.add(new FastTowerOption(defenderTypeFactory));
        constructionMenuOptions.add(new FastTowerOption(defenderTypeFactory));
        constructionMenuOptions.add(new FastTowerOption(defenderTypeFactory));
    }

    @Override
    public List<MenuOption> getConstructionMenuOptions() {
        return constructionMenuOptions;
    }
}
