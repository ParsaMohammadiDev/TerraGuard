package ir.ac.kntu.services.app.menus.factories;

import ir.ac.kntu.services.app.menus.ConstructionMenu;
import ir.ac.kntu.services.app.menus.Menu;
import ir.ac.kntu.services.app.menus.options.MenuOption;
import ir.ac.kntu.services.app.menus.options.providers.MenuOptionProvider;

import java.util.List;

public class SimpleMenuFactory implements MenuFactory {
    private final Menu constructionMenu;

    public SimpleMenuFactory(MenuOptionProvider menuOptionProvider) {
        constructionMenu = new ConstructionMenu(menuOptionProvider.getConstructionMenuOptions());
    }
    @Override
    public Menu getConstructionMenu() {
        return constructionMenu;
    }
}