package ir.ac.kntu.components.tiles.factories;

import ir.ac.kntu.components.tiles.Grass;
import ir.ac.kntu.components.tiles.Tile;
import ir.ac.kntu.components.tiles.TileType;
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
        };
    }
}
