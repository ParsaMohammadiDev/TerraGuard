package ir.ac.kntu.services.app.animations;

import javafx.scene.Node;

public class KillerAnimation implements Animation {
    @Override
    public void animate(Node... nodes) {
        for (Node node : nodes) {
            node.setOnMouseExited(null);
            node.setOnMouseEntered(null);
            node.setOpacity(1);
        }
    }
}