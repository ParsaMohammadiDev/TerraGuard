package ir.ac.kntu.services.game.components.bullets;

import javafx.scene.image.Image;

public enum BulletType {
    NORMAL_BULLET(
            new Image("/game/components/bullets/normal_bullet.png"),
            new Image("/game/components/effects/normal_bullet_impact.png")),
    FAST_BULLET(
            new Image("/game/components/bullets/fast_bullet.png"),
            new Image("/game/components/effects/normal_bullet_impact.png"));

    private final Image image;
    private final Image impactImage;

    BulletType(Image image, Image impactImage) {
        this.image = image;
        this.impactImage = impactImage;
    }

    public Image getImage() {
        return image;
    }

    public Image getImpactImage() {return impactImage;}
}