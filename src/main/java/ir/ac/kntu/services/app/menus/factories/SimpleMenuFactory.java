package ir.ac.kntu.services.app.menus.factories;

import ir.ac.kntu.services.app.menus.ConstructionMenu;
import ir.ac.kntu.services.app.menus.Menu;
import ir.ac.kntu.services.app.menus.options.MenuOption;
import java.util.List;

public class SimpleMenuFactory implements MenuFactory {
    @Override
    public Menu getConstructionMenu(List<MenuOption> options) {
        return new ConstructionMenu(options);
    }
}