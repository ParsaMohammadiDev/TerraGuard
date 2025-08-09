package ir.ac.kntu.animations;

import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class ButtonHoverAnimation implements Animation {
    private static final Duration DURATION = Duration.millis(200);
    private static final double FINAL_SCALE = 1.1;
    @Override
    public void animate(Node... nodes) {
        for (Node node : nodes) {
            node.setOnMouseEntered(event -> {
                ScaleTransition zoomOut = new ScaleTransition(DURATION, node);
                zoomOut.setToX(FINAL_SCALE);
                zoomOut.setToY(FINAL_SCALE);
                zoomOut.play();
            });

            node.setOnMouseExited(event -> {
                ScaleTransition zoomIn = new ScaleTransition(DURATION, node);
                zoomIn.setToX(1);
                zoomIn.setToY(1);
                zoomIn.play();
            });
        }
    }
}
