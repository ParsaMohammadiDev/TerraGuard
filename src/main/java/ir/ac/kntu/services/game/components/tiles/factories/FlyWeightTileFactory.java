package ir.ac.kntu.services.game.components.tiles.factories;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.game.components.tiles.*;
import ir.ac.kntu.services.game.components.tiles.states.providers.TileStateProvider;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightTileFactory implements TileFactory {
    private static final double TILE_SIZE = 70;

    private final AnimationFactory animFactory;
    private final TileStateProvider tileStateProvider;

    private final Map<TileType, Tile> tiles = new HashMap<>();

    public FlyWeightTileFactory(AnimationFactory animFactory, TileStateProvider tileStateProvider) {
        this.animFactory = animFactory;
        this.tileStateProvider = tileStateProvider;
    }

    @Override
    public Tile getTile(TileType tileType) {
        if (tileType.equals(TileType.CONSTRUCTION)) {
            return new Construction(tileType, TILE_SIZE, tileStateProvider.getUnclickedTileState());
        }
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
            case EMPTY -> new Empty(tileType, TILE_SIZE);
            default -> throw new IllegalStateException("Unexpected value TileType: " + tileType);
        };
    }
}