package ir.ac.kntu.services.game.core.renderers;

import ir.ac.kntu.services.game.components.Shooter;
import ir.ac.kntu.services.game.components.bullets.Bullet;
import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class SimpleEffectRenderer implements EffectRenderer {
    private static final Duration IMPACT_DURATION = Duration.millis(100);
    private static final double INIT_EFFECT_SCALE = 0.1;
    private static final double FINIAL_EFFECT_SCALE = 1;

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
                new KeyFrame(Duration.seconds(shooter.getShootingDelay() / 2),
                        new KeyValue(muzzle.rotateProperty(), endAngle, Interpolator.EASE_BOTH))
        );
        timeline.play();
    }

    @Override
    public void playBulletImpactEffect(Bullet bullet) {
        ImageView impactView = new ImageView(bullet.getType().getImpactImage());
        impactView.setScaleX(INIT_EFFECT_SCALE);
        impactView.setScaleY(INIT_EFFECT_SCALE);
        impactView.setLayoutX(bullet.getView().getLayoutX());
        impactView.setLayoutY(bullet.getView().getLayoutY());
        var pane = bullet.getView().getParent();
        if (pane instanceof Pane gamePane) {
            gamePane.getChildren().add(impactView);
        }

        ScaleTransition popup = new ScaleTransition(Duration.millis(100), impactView);
        popup.setToX(FINIAL_EFFECT_SCALE);
        popup.setToY(FINIAL_EFFECT_SCALE);

        popup.setOnFinished((e) -> {
            impactView.setVisible(false);
            if (pane instanceof Pane gamePane) {
                gamePane.getChildren().remove(impactView);
            }
        });
        popup.play();
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
