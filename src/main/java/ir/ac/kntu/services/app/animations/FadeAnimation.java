package ir.ac.kntu.services.app.animations;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeAnimation implements Animation {
    private static final double INIT_OPACITY = 0;
    private static final double FINIAL_OPACITY = 1;
    private static final Duration FADE_DURATION = Duration.millis(500);

    @Override
    public void animate(Node... nodes) {
        for (Node node : nodes) {
            node.setOpacity(INIT_OPACITY);
            FadeTransition fade = new FadeTransition(FADE_DURATION, node);
            fade.setFromValue(INIT_OPACITY);
            fade.setToValue(FINIAL_OPACITY);
            fade.play();
        }
    }
}
