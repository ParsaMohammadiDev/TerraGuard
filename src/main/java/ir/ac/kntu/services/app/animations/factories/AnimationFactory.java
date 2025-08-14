package ir.ac.kntu.services.app.animations.factories;

import ir.ac.kntu.services.app.animations.Animation;

public interface AnimationFactory {
    Animation getZoomAndFadeAnimation();
    Animation getButtonHoverAnimation();
    Animation getTileHoverAnimation();
}
