package ir.ac.kntu.services.app.menus.factories;

import ir.ac.kntu.services.app.menus.Menu;
import ir.ac.kntu.services.app.menus.options.MenuOption;

import java.util.List;

public interface MenuFactory {
    Menu getConstructionMenu(List<MenuOption> options);
}