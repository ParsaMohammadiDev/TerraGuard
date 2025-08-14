package ir.ac.kntu.services.game;

import ir.ac.kntu.services.game.components.maps.renderers.MapRenderer;
import ir.ac.kntu.services.game.components.tiles.factories.TileFactory;
import ir.ac.kntu.services.game.core.GameEngine;
import ir.ac.kntu.services.game.core.difficulties.factories.DifficultyFactory;

public interface GameServices {
    GameEngine getGameEngine();
    MapRenderer getMapRenderer();
    DifficultyFactory getDifficultyFactory();
    TileFactory getTileFactory();
    void setGameEngine(GameEngine gameEngine);
    void setMapRenderer(MapRenderer mapRenderer);
    void setDifficultyFactory(DifficultyFactory difficultyFactory);
    void setTileFactory(TileFactory tileFactory);
}