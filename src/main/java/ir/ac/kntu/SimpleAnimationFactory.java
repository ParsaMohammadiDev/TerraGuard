package ir.ac.kntu;

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