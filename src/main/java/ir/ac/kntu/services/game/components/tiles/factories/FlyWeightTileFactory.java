package ir.ac.kntu.services.game.components.tiles.factories;

import ir.ac.kntu.services.app.AppServices;
import ir.ac.kntu.services.game.components.tiles.*;
import java.util.HashMap;
import java.util.Map;

public class FlyWeightTileFactory implements TileFactory {
    private final AppServices appServices;
    private final Map<TileType, Tile> tiles = new HashMap<TileType, Tile>();

    public FlyWeightTileFactory(AppServices appServices) {
        this.appServices = appServices;
    }

    @Override
    public Tile getTile(TileType tileType) {
        return tiles.computeIfAbsent(tileType, this::createTile);
    }

    private Tile createTile(TileType tileType) {
        return switch (tileType) {
            case GRASS -> new Grass(tileType);
            case ROAD -> new Road(tileType);
            case PLANT -> new Plant(tileType);
            case ROCK -> new Rock(tileType);
            case PARTICLES -> new Particles(tileType);
            case SAND -> new Sand(tileType);
            case STONE -> new Stone(tileType);
            case CONSTRUCTION -> new Construction(tileType, appServices);
            case EMPTY -> new Empty(tileType);
        };
    }
}