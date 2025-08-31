package ir.ac.kntu.services.app.menus;

import ir.ac.kntu.services.app.menus.options.ConstructionOption;import ir.ac.kntu.services.app.menus.options.MenuOption;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.util.List;

public class ConstructionMenu implements Menu {
    private final VBox menuPane;

    private ClickableTile tile;

    public ConstructionMenu(List<ConstructionOption> options) {
        Pane pane = new VBox();
        for (ConstructionOption option : options) {
            option.setMenu(this);
            pane.getChildren().add(option.getView());
        }
        pane.getStyleClass().add("scroll_pane");
        ScrollPane scrollPane = new ScrollPane(pane);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        menuPane = new VBox(scrollPane);
        menuPane.getStyleClass().add("construction_menu");
        menuPane.setPrefSize(450, 200);
        menuPane.setAlignment(Pos.TOP_CENTER);
        menuPane.setVisible(false);
    }

    public ClickableTile getTile() {
        return tile;
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

    @Override
    public void setInvoker(Object invoker) {
        this.tile = (ClickableTile) invoker;
    }

    @Override
    public Object getInvoker() {
        return tile;
    }
}
