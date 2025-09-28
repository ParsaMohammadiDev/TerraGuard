package ir.ac.kntu.services.game.components;

import ir.ac.kntu.services.game.components.bullets.BulletType;
import javafx.geometry.Point2D;
import javafx.scene.Node;

public interface Shooter {
    BulletType getBulletType();
    Point2D getMuzzlePosition();
    Node getMuzzleView();
}