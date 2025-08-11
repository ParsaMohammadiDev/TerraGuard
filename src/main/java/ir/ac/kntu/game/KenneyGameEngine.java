package ir.ac.kntu.game;

import ir.ac.kntu.animations.factories.AnimationFactory;
import ir.ac.kntu.components.maps.GrassLand;
import ir.ac.kntu.components.maps.renderers.GridMapRenderer;
import ir.ac.kntu.components.maps.renderers.MapRenderer;
import ir.ac.kntu.components.tiles.factories.FlyWeightTileFactory;
import ir.ac.kntu.components.tiles.factories.TileFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class KenneyGameEngine implements GameEngine {
    private final TileFactory tileFactory;
    private final MapRenderer mapRenderer;
    private final AnimationFactory animFactory;

    public KenneyGameEngine(AnimationFactory animFactory) {
        this.animFactory = animFactory;
        tileFactory = new FlyWeightTileFactory(animFactory);
        mapRenderer = new GridMapRenderer(tileFactory);
    }

    @Override
    public Pane getGamePane() {
        StackPane gamePane = new StackPane();
        gamePane.getChildren().add(mapRenderer.renderMap(new GrassLand()));
        return gamePane;
    }
}