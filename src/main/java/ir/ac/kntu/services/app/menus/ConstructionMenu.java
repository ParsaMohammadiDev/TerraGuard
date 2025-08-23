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
    private final VBox menuPane;

    public ConstructionMenu(List<MenuOption> options) {
        this.options = options;
        Pane pane = new VBox();
        for (MenuOption option : options) {
            pane.getChildren().add(option.getView());
        }
        ScrollPane scrollPane = new ScrollPane(pane);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        menuPane = new VBox(scrollPane);
        menuPane.getStyleClass().add("construction_menu");
        menuPane.setPrefSize(350, 200);
        menuPane.setAlignment(Pos.TOP_CENTER);
        menuPane.setVisible(false);
    }

    @Override
    public Node getView() {
        return menuPane;
    }

    @Override
    public void show() {
        menuPane.setVisible(true);
    }

    @Override
    public void hide() {
        menuPane.setVisible(false);
    }
}
