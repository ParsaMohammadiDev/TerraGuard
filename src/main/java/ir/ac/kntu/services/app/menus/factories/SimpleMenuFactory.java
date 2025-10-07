package ir.ac.kntu.services.app.menus.factories;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.menus.ConstructionMenu;
import ir.ac.kntu.services.app.menus.Menu;
import ir.ac.kntu.services.app.menus.options.providers.MenuOptionProvider;

public class SimpleMenuFactory implements MenuFactory {
    private Menu constructionMenu;
    private MenuOptionProvider optionProvider;
    private final AnimationFactory animFactory;

    public SimpleMenuFactory(AnimationFactory animFactory) {
        this.animFactory = animFactory;
    }

    public void setOptionProvider(MenuOptionProvider optionProvider) {
        this.optionProvider = optionProvider;
        constructionMenu = new ConstructionMenu(optionProvider.getConstructionMenuOptions(), animFactory);
    }

    @Override
    public Menu getConstructionMenu() {
        return constructionMenu;
    }
}