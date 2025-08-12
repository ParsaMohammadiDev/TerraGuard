package ir.ac.kntu.components.tiles;

import javafx.scene.image.Image;

public class Particles extends Tile {
    private static final String PARTICLES_PATH = "/game/components/tiles/particles.png";
    private static final Image PARTICLES_IMAGE = new Image(PARTICLES_PATH);

    public Particles(TileType tileType) {
        super(tileType);
    }

    @Override
    public Image getImage() {
        return PARTICLES_IMAGE;
    }
}
