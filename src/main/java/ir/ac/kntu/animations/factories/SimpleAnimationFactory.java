package ir.ac.kntu.animations.factories;

import ir.ac.kntu.animations.Animation;
import ir.ac.kntu.animations.ButtonHoverAnimation;
import ir.ac.kntu.animations.TileHoverAnimation;
import ir.ac.kntu.animations.ZoomAndFadeAnimation;

public class SimpleAnimationFactory implements AnimationFactory {
    @Override
    public Animation getZoomAndFadeAnimation() {
        return new ZoomAndFadeAnimation();
    }

    @Override
    public Animation getButtonHoverAnimation() {
        return new ButtonHoverAnimation();
    }

    @Override
    public Animation getTileHoverAnimation() {
        return new TileHoverAnimation();
    }
}