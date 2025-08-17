package ir.ac.kntu.services.game.components.tiles.factories;

import ir.ac.kntu.services.game.components.tiles.Tile;
import ir.ac.kntu.services.game.components.tiles.TileType;

public interface TileFactory {
    Tile getTile(TileType tileType);
    double getTileSize();
}