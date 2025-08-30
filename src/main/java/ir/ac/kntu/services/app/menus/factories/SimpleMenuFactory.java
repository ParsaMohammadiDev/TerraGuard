package ir.ac.kntu.services.app.menus.factories;

import ir.ac.kntu.services.app.menus.ConstructionMenu;
import ir.ac.kntu.services.app.menus.Menu;
import ir.ac.kntu.services.app.menus.options.providers.MenuOptionProvider;

import java.util.List;

public class SimpleMenuFactory implements MenuFactory {
    private Menu constructionMenu;
    private MenuOptionProvider optionProvider;

    public void setOptionProvider(MenuOptionProvider optionProvider) {
        this.optionProvider = optionProvider;
        constructionMenu = new ConstructionMenu(optionProvider.getConstructionMenuOptions());
    }

    @Override
    public Menu getConstructionMenu() {
        return constructionMenu;
    }
}