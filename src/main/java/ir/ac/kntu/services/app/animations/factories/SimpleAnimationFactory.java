package ir.ac.kntu.services.app.animations.factories;

import ir.ac.kntu.services.app.animations.*;

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

    @Override
    public Animation getKillerAnimation() {
        return new KillerAnimation();
    }

    @Override
    public Animation getFadeAnimation() {
        return new FadeAnimation();
    }
}