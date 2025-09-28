package ir.ac.kntu.services.game.core.renderers;

import ir.ac.kntu.services.game.components.Shooter;

public interface EffectRenderer {
    void rotateMuzzle(Shooter shooter, double angle, double duration);
}