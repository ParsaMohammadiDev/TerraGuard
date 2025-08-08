package ir.ac.kntu.Animations.Factories;

import ir.ac.kntu.Animations.Animation;
import ir.ac.kntu.Animations.ButtonHoverAnimation;
import ir.ac.kntu.Animations.ZoomAndFadeAnimation;

public class SimpleAnimationFactory implements AnimationFactory {
    @Override
    public Animation getZoomAndFadeAnimation() {
        return new ZoomAndFadeAnimation();
    }

    @Override
    public Animation getButtonHoverAnimation() {
        return new ButtonHoverAnimation();
    }
}