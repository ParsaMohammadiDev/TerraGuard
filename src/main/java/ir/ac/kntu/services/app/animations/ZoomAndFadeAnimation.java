package ir.ac.kntu.services.app.animations;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class ZoomAndFadeAnimation implements Animation {
    private static final Duration ANIMATION_DURATION = Duration.millis(500);
    private static final double INIT_SCALE = 0.8;
    private static final double FINAL_SCALE = 1.0;
    private static final double INIT_OPACITY = 0;
    private static final double FINAL_OPACITY = 1.0;
    private static final double DELAY = 0.5;

    @Override
    public void animate(Node... nodes) {
        double delayAccumulator = 0;

        for (Node node : nodes) {
            setStartFrame(node);
            FadeTransition fade = new FadeTransition(ANIMATION_DURATION, node);
            fade.setFromValue(INIT_OPACITY);
            fade.setToValue(FINAL_OPACITY);
            fade.setCycleCount(1);
            fade.setDelay(Duration.seconds(delayAccumulator));
            ScaleTransition zoomOut = new ScaleTransition(ANIMATION_DURATION, node);
            zoomOut.setFromX(INIT_SCALE);
            zoomOut.setFromY(INIT_SCALE);
            zoomOut.setToX(FINAL_SCALE);
            zoomOut.setToY(FINAL_SCALE);
            zoomOut.setDelay(Duration.seconds(delayAccumulator));
            ParallelTransition animationGroup = new ParallelTransition(fade, zoomOut);
            animationGroup.play();
            delayAccumulator += DELAY;
        }
    }

    private void setStartFrame(Node node) {
        node.setOpacity(INIT_OPACITY);
        node.setScaleX(INIT_SCALE);
        node.setScaleY(INIT_SCALE);
    }
}
