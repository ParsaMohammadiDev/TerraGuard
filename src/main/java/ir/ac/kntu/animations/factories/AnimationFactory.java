package ir.ac.kntu.animations.factories;

import ir.ac.kntu.animations.Animation;

public interface AnimationFactory {
    Animation getZoomAndFadeAnimation();
    Animation getButtonHoverAnimation();
}
