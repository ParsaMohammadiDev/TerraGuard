package ir.ac.kntu.services.game.components.bullets;

import javafx.scene.image.Image;

public enum BulletType {
    NORMAL_BULLET(new Image("/game/components/bullets/normal_bullet.png")),
    FAST_BULLET(new Image("/game/components/bullets/fast_bullet.png"));

    private final Image image;

    private BulletType(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
}