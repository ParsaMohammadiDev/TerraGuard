package ir.ac.kntu.services.game.components.bullets;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public abstract class Bullet {
    private final ImageView view;
    private BulletType type;
    private double x;
    private double y;
    private double speed;

    public Bullet(BulletType type, double speed) {
        this.type = type;
        this.speed = speed;
        view = new ImageView();
        view.setImage(type.getImage());
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
        view.setLayoutX(x);
        view.setLayoutY(y);
    }

    public BulletType getType() {
        return type;
    }

    public double getSpeed() {
        return speed;
    }

    public Node getView() {
        return view;
    }
}