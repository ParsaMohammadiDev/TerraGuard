package ir.ac.kntu.services.game.components;

import javafx.scene.Node;

public interface Collidable {
    double getCollisionMargin();
    Node getView();
}