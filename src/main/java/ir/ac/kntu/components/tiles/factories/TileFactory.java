package ir.ac.kntu.components.tiles.factories;

import ir.ac.kntu.components.tiles.Tile;
import ir.ac.kntu.components.tiles.TileType;

public interface TileFactory {
    Tile getTile(TileType tileType);
}