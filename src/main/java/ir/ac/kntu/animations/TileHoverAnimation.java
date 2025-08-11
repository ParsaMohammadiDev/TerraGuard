package ir.ac.kntu.animations;

import javafx.scene.Node;

public class TileHoverAnimation implements Animation {
    private static final double INIT_OPACITY = 0.3;
    @Override
    public void animate(Node... nodes) {
        for (Node node : nodes) {
            setStartFrame(node);
            node.setOnMouseEntered(event -> {
                node.setOpacity(1);
            });

            node.setOnMouseExited(event -> {
                setStartFrame(node);
            });
        }
    }

    private void setStartFrame(Node node) {
        node.setOpacity(INIT_OPACITY);
    }
}
