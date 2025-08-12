package ir.ac.kntu.components.maps;

import ir.ac.kntu.components.tiles.TileType;

public class StoneLand implements Map {
    private static final TileType[][] TERRAIN_MAP = {
            {TileType.STONE, TileType.ROAD, TileType.ROAD, TileType.STONE, TileType.STONE, TileType.STONE, TileType.STONE, TileType.STONE, TileType.STONE},
            {TileType.STONE, TileType.ROAD, TileType.ROAD, TileType.STONE, TileType.STONE, TileType.STONE, TileType.STONE, TileType.STONE, TileType.STONE},
            {TileType.STONE, TileType.ROAD, TileType.ROAD, TileType.STONE, TileType.STONE, TileType.STONE, TileType.STONE, TileType.STONE, TileType.STONE},
            {TileType.STONE, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.STONE, TileType.STONE, TileType.STONE},
            {TileType.STONE, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.STONE, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD},
            {TileType.STONE, TileType.STONE, TileType.STONE, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD},
            {TileType.STONE, TileType.STONE, TileType.STONE, TileType.STONE, TileType.STONE, TileType.STONE, TileType.STONE, TileType.STONE, TileType.STONE},
    };

    private static final TileType[][] OVERLAY_MAP = {
            {TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.PLANT, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.ROCK},
            {TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.PLANT, TileType.EMPTY, TileType.PARTICLES, TileType.EMPTY},
            {TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY, TileType.PARTICLES, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
            {TileType.PARTICLES, TileType.EMPTY, TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.CONSTRUCTION, TileType.CONSTRUCTION},
            {TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
            {TileType.EMPTY, TileType.EMPTY, TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY},
            {TileType.ROCK, TileType.EMPTY, TileType.CONSTRUCTION, TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY, TileType.PARTICLES, TileType.EMPTY, TileType.EMPTY},
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
