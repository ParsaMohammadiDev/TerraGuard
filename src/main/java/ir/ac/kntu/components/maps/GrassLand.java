package ir.ac.kntu.components.maps;

import ir.ac.kntu.components.tiles.TileType;

public class GrassLand implements Map {
    private static final TileType[][] TERRAIN_MAP = {
            {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
    };

    private static final TileType[][] OVERLAY_MAP = {
            {TileType.PLANT, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.CONSTRUCTION, TileType.CONSTRUCTION, TileType.ROCK},
            {TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY, TileType.CONSTRUCTION, TileType.EMPTY},
            {TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
            {TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.ROCK, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
                {TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
            {TileType.PLANT, TileType.EMPTY, TileType.EMPTY, TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY, TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY},
            {TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.PLANT, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
    };

    @Override
    public TileType[][] getTerrainMapArray() {
        return TERRAIN_MAP;
    }

    @Override
    public TileType[][] getOverlayMapArray() {
        return OVERLAY_MAP;
    }
}