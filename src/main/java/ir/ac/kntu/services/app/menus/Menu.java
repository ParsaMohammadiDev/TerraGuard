package ir.ac.kntu.services.app.menus;

import javafx.scene.Node;

public interface Menu {
    Node getView();
    void show();
    void hide();
    void setInvoker(Object invoker);
}