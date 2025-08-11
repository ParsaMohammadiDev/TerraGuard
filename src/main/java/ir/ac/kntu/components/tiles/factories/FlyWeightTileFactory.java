package ir.ac.kntu.components.tiles.factories;

import ir.ac.kntu.animations.factories.AnimationFactory;
import ir.ac.kntu.components.tiles.*;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightTileFactory implements TileFactory {
    private final AnimationFactory animFactory;
    private final Map<TileType, Tile> tiles = new HashMap<TileType, Tile>();

    public FlyWeightTileFactory(AnimationFactory animFactory) {
        this.animFactory = animFactory;
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
            case CONSTRUCTION -> new Construction(tileType, animFactory);
            case EMPTY -> new Empty(tileType);
        };
    }
}