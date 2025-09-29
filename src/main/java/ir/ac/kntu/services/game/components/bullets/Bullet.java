package ir.ac.kntu.services.game.components.bullets;

import ir.ac.kntu.services.game.components.Collidable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public abstract class Bullet implements Collidable {
    private final ImageView view;
    private BulletType type;
    private double x;
    private double y;
    private double speed;
    private double damageCoefficient;

    public Bullet(BulletType type, double speed, double damageCoefficient) {
        this.type = type;
        this.speed = speed;
        this.damageCoefficient = damageCoefficient;
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
    
    public double getDamageCoefficient() {
        return damageCoefficient;
    }

    public Node getView() {
        return view;
    }
}