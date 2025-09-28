package ir.ac.kntu.services.game.core.renderers;

import ir.ac.kntu.services.game.components.Shooter;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class SimpleEffectRenderer implements EffectRenderer {
    private Timeline timeline;

    @Override
    public void rotateMuzzle(Shooter shooter, double targetAngle) {
        Node muzzle = shooter.getMuzzleView();

        double current = muzzle.getRotate();
        double delta = shortestDelta(current, targetAngle);
        double endAngle = current + delta;

        if (timeline != null) {
            timeline.stop();
        }

        timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(muzzle.rotateProperty(), current)),
                new KeyFrame(Duration.seconds(shooter.getShootingDelay()),
                        new KeyValue(muzzle.rotateProperty(), endAngle, Interpolator.EASE_BOTH))
        );
        timeline.play();
    }

    private double normalize180(double a) {
        a = ((a % 360) + 360) % 360;
        if (a > 180) a -= 360;
        return a;
    }

    private double shortestDelta(double fromAngle, double toAngle) {
        double delta = normalize180(toAngle) - normalize180(fromAngle);
        if (delta > 180) delta -= 360;
        if (delta <= -180) delta += 360;
        return delta;
    }
}
