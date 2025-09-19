package ir.ac.kntu.services.game.components.bullets.managers;

import ir.ac.kntu.services.game.components.Entity;
import ir.ac.kntu.services.game.components.Shooter;

public interface BulletManager {
    void shoot(Shooter shooter, Entity target);
}