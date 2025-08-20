package ir.ac.kntu.services.app.menus;

import ir.ac.kntu.services.app.menus.options.MenuOption;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.util.List;

public class ConstructionMenu implements Menu {
    private final List<MenuOption> options;
    private final ScrollPane scrollPane;

    public ConstructionMenu(List<MenuOption> options) {
        this.options = options;
        Pane pane = new VBox();
        for (MenuOption option : options) {
            pane.getChildren().add(option.getView());
        }
        scrollPane = new ScrollPane(pane);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }

    @Override
    public Node getView() {
        VBox menu = new VBox(scrollPane);
        menu.getStyleClass().add("construction_menu");
        menu.setPrefSize(350, 200);
        menu.setAlignment(Pos.CENTER_LEFT);
        return menu;
    }

    @Override
    public void show() {
        scrollPane.setVisible(true);
    }

    @Override
    public void hide() {
        scrollPane.setVisible(false);
    }
}
