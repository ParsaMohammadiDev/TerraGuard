package ir.ac.kntu.services.game.components.tiles.factories;

import ir.ac.kntu.services.app.AppServices;
import ir.ac.kntu.services.game.components.tiles.*;
import java.util.HashMap;
import java.util.Map;

public class FlyWeightTileFactory implements TileFactory {
    private static final double TILE_SIZE = 70;
    private final AppServices appServices;
    private final Map<TileType, Tile> tiles = new HashMap<TileType, Tile>();

    public FlyWeightTileFactory(AppServices appServices) {
        this.appServices = appServices;
    }

    @Override
    public Tile getTile(TileType tileType) {
        return tiles.computeIfAbsent(tileType, this::createTile);
    }

    @Override
    public double getTileSize() {
        return TILE_SIZE;
    }

    private Tile createTile(TileType tileType) {
        return switch (tileType) {
            case GRASS -> new Grass(tileType, TILE_SIZE);
            case ROAD -> new Road(tileType, TILE_SIZE);
            case PLANT -> new Plant(tileType, TILE_SIZE);
            case ROCK -> new Rock(tileType, TILE_SIZE);
            case PARTICLES -> new Particles(tileType, TILE_SIZE);
            case SAND -> new Sand(tileType, TILE_SIZE);
            case STONE -> new Stone(tileType, TILE_SIZE);
            case CONSTRUCTION -> new Construction(tileType, appServices, TILE_SIZE);
            case EMPTY -> new Empty(tileType, TILE_SIZE);
        };
    }
}