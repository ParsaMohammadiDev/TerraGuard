package ir.ac.kntu.services.game.components;

import javafx.scene.Node;

public interface Entity {
    Node getView();
    double getHealth();
    void damage(double amount);
}