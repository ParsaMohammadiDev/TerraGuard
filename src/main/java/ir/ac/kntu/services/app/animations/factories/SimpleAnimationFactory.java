package ir.ac.kntu.services.app.animations.factories;

import ir.ac.kntu.services.app.animations.Animation;
import ir.ac.kntu.services.app.animations.ButtonHoverAnimation;
import ir.ac.kntu.services.app.animations.TileHoverAnimation;
import ir.ac.kntu.services.app.animations.ZoomAndFadeAnimation;

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