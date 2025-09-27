package ir.ac.kntu.services.game.components;

import ir.ac.kntu.services.game.components.bullets.BulletType;
import javafx.geometry.Point2D;

public interface Shooter {
    BulletType getBulletType();
    Point2D getMuzzlePosition();
}