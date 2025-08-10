package ir.ac.kntu.game;

import ir.ac.kntu.components.maps.GrassLand;
import ir.ac.kntu.components.maps.renderers.GridMapRenderer;
import ir.ac.kntu.components.maps.renderers.MapRenderer;
import ir.ac.kntu.components.tiles.factories.FlyWeightTileFactory;
import javafx.scene.Node;

public class KenneyGameEngine implements GameEngine {
    private MapRenderer mapRenderer = new GridMapRenderer(new FlyWeightTileFactory());
    @Override
    public Node getGamePane() {
        return mapRenderer.renderMap(new GrassLand());
    }
}