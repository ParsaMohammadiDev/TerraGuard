package ir.ac.kntu.components.maps;

import ir.ac.kntu.components.tiles.TileType;

public class GrassLand implements Map {
    private static final TileType[][] mapArray = {
            {TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD},
            {TileType.GRASS, TileType.ROAD, TileType.ROAD, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS, TileType.GRASS},
    };

    @Override
    public TileType[][] getMapArray() {
        return mapArray;
    }
}