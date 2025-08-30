package ir.ac.kntu.services.app.menus.options.providers;

import ir.ac.kntu.services.app.menus.options.ConstructionOption;
import ir.ac.kntu.services.app.menus.options.MenuOption;
import java.util.List;

public interface MenuOptionProvider {
    List<ConstructionOption> getConstructionMenuOptions();
}
