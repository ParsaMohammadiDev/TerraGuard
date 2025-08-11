package ir.ac.kntu.components.tiles.factories;

import ir.ac.kntu.components.tiles.*;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightTileFactory implements TileFactory {
    private final Map<TileType, Tile> tiles = new HashMap<TileType, Tile>();
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
            case EMPTY -> new Empty(tileType);
        };
    }
}