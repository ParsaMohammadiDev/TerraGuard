package ir.ac.kntu.services.game.components.enemies.types;

import javafx.scene.image.Image;

public class SoliderType implements EnemyType {
    private static final String SOLIDER_BASE_PATH = "/game/components/enemies/bases/solider.png";
    private static final Image SOLIDER_BASE_IMAGE = new Image(SOLIDER_BASE_PATH);
    private static final String SOLIDER_OVERLAY_PATH = "/game/components/enemies/overlays/empty.png";
    private static final Image SOLIDER_OVERLAY_IMAGE = new Image(SOLIDER_OVERLAY_PATH);

    @Override
    public Image getBaseImage() {
        return SOLIDER_BASE_IMAGE;
    }

    @Override
    public Image getOverlayImage() {
        return SOLIDER_OVERLAY_IMAGE;
    }

    @Override
    public boolean equals(final Object obj) {

    }
}