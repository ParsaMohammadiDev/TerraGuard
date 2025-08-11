package ir.ac.kntu.components.maps;

import ir.ac.kntu.components.tiles.TileType;

public class GrassLand implements Map {
    private static final TileType[][] terrainMap = {
            {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
    };

    private static final TileType[][] overlayMap = {
            {TileType.PLANT, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.ROCK},
            {TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
            {TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
            {TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.ROCK, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
            {TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
            {TileType.PLANT, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
            {TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.PLANT, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
    };

    @Override
    public TileType[][] getTerrainMapArray() {
        return terrainMap;
    }

    @Override
    public TileType[][] getOverlayMapArray() {
        return overlayMap;
    }
}