package ir.ac.kntu.services.game.components.bullets;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public abstract class Bullet {
    private final ImageView view;
    private BulletType type;

    public Bullet(BulletType type) {
        this.type = type;
        view = new ImageView();
        view.setImage(type.getImage());
    }

    public BulletType getType() {
        return type;
    }

    public Node getView() {
        return view;
    }
}