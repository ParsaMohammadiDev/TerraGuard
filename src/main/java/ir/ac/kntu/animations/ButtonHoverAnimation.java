package ir.ac.kntu.animations;

import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class ButtonHoverAnimation implements Animation {
    private static final Duration DURATION = Duration.millis(200);
    private static final Duration PRESSED_DURATION = Duration.millis(50);
    private static final double HOVERED_SCALE = 1.1;
    private static final double PRESSED_SCALE = 1.08;
    @Override
    public void animate(Node... nodes) {
        for (Node node : nodes) {
            node.setOnMouseEntered(event -> {
                ScaleTransition zoomOut = new ScaleTransition(DURATION, node);
                zoomOut.setToX(HOVERED_SCALE);
                zoomOut.setToY(HOVERED_SCALE);
                zoomOut.play();
            });

            node.setOnMouseExited(event -> {
                ScaleTransition zoomIn = new ScaleTransition(DURATION, node);
                zoomIn.setToX(1);
                zoomIn.setToY(1);
                zoomIn.play();
            });

            node.setOnMousePressed(event -> {
                ScaleTransition zoomIn = new ScaleTransition(PRESSED_DURATION, node);
                zoomIn.setToX(PRESSED_SCALE);
                zoomIn.setToY(PRESSED_SCALE);
                zoomIn.play();
            });

            node.setOnMouseReleased(event -> {
                ScaleTransition zoomOut = new ScaleTransition(PRESSED_DURATION, node);
                zoomOut.setToX(HOVERED_SCALE);
                zoomOut.setToY(HOVERED_SCALE);
                zoomOut.play();
            });
        }
    }
}
