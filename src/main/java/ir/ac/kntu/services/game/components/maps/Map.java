package ir.ac.kntu.services.game.components.maps;

import ir.ac.kntu.services.game.components.tiles.TileType;

public interface Map {
    TileType[][] getTerrainMapArray();
    TileType[][] getOverlayMapArray();
    int getStartRow();
    int getStartCol();
    int getEndRow();
    int getEndCol();
}