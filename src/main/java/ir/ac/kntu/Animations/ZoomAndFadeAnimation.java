package ir.ac.kntu.Animations;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class ZoomAndFadeAnimation implements Animation {
    private static final double ANIMATION_DURATION = 1;
    private static final double INIT_SCALE = 0.8;
    private static final double FINAL_SCALE = 1.0;
    private static final double INIT_OPACITY = 0;
    private static final double FINAL_OPACITY = 1.0;
    private static final double DELAY = 0.5;

    @Override
    public void animate(Node... nodes) {
        double delayAcumulator = 0;

        for (Node node : nodes) {
            setStartFrame(node);
            FadeTransition fade = new FadeTransition(Duration.seconds(ANIMATION_DURATION), node);
            fade.setFromValue(INIT_OPACITY);
            fade.setToValue(FINAL_OPACITY);
            fade.setCycleCount(1);
            fade.setDelay(Duration.seconds(delayAcumulator));
            ScaleTransition zoomOut = new ScaleTransition(Duration.seconds(ANIMATION_DURATION), node);
            zoomOut.setFromX(INIT_SCALE);
            zoomOut.setFromY(INIT_SCALE);
            zoomOut.setToX(FINAL_SCALE);
            zoomOut.setToY(FINAL_SCALE);
            zoomOut.setDelay(Duration.seconds(delayAcumulator));
            ParallelTransition animationGroup = new ParallelTransition(fade, zoomOut);
            animationGroup.play();
            delayAcumulator += DELAY;
        }
    }

    private void setStartFrame(Node node) {
        node.setOpacity(INIT_OPACITY);
        node.setScaleX(INIT_SCALE);
        node.setScaleY(INIT_SCALE);
    }
}
