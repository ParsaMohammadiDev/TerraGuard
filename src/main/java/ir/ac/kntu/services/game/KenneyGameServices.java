package ir.ac.kntu.services.game;

import ir.ac.kntu.services.game.components.maps.renderers.MapRenderer;
import ir.ac.kntu.services.game.components.tiles.factories.TileFactory;
import ir.ac.kntu.services.game.core.GameEngine;
import ir.ac.kntu.services.game.core.difficulties.factories.DifficultyFactory;

public class KenneyGameServices implements GameServices {
    private GameEngine gameEngine;
    private MapRenderer mapRenderer;
    private DifficultyFactory difficultyFactory;
    private TileFactory tileFactory;

    @Override
    public GameEngine getGameEngine() {
        return gameEngine;
    }

    @Override
    public MapRenderer getMapRenderer() {
        return mapRenderer;
    }

    @Override
    public DifficultyFactory getDifficultyFactory() {
        return difficultyFactory;
    }

    @Override
    public TileFactory getTileFactory() {
        return tileFactory;
    }

    @Override
    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void setMapRenderer(MapRenderer mapRenderer) {
        this.mapRenderer = mapRenderer;
    }

    @Override
    public void setDifficultyFactory(DifficultyFactory difficultyFactory) {
        this.difficultyFactory = difficultyFactory;
    }

    @Override
    public void setTileFactory(TileFactory tileFactory) {
        this.tileFactory = tileFactory;
    }
}
