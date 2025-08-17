package ir.ac.kntu.services.game.components.maps;

import ir.ac.kntu.services.game.components.tiles.TileType;
import javafx.geometry.Point2D;

public class Desert implements Map {
    private static final int START_ROW = 1;
    private static final int START_COL = 0;
    private static final int END_ROW = 3;
    private static final int END_COL = 8;

    private static final TileType[][] TERRAIN_MAP = {
            {TileType.SAND, TileType.SAND, TileType.SAND, TileType.SAND, TileType.SAND, TileType.SAND, TileType.SAND, TileType.SAND, TileType.SAND},
            {TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.SAND, TileType.SAND, TileType.SAND, TileType.SAND, TileType.SAND, TileType.SAND},
            {TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.SAND, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD},
            {TileType.SAND, TileType.ROAD, TileType.ROAD, TileType.SAND, TileType.ROAD, TileType.SAND, TileType.ROAD, TileType.ROAD, TileType.ROAD},
            {TileType.SAND, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.SAND, TileType.ROAD, TileType.SAND, TileType.SAND},
            {TileType.SAND, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.ROAD, TileType.SAND, TileType.SAND},
            {TileType.SAND, TileType.SAND, TileType.SAND, TileType.SAND, TileType.SAND, TileType.SAND, TileType.SAND, TileType.SAND, TileType.SAND},
    };

    private static final TileType[][] OVERLAY_MAP = {
            {TileType.PARTICLES, TileType.EMPTY, TileType.CONSTRUCTION, TileType.CONSTRUCTION, TileType.EMPTY, TileType.ROCK, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
            {TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.CONSTRUCTION, TileType.CONSTRUCTION},
            {TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
            {TileType.EMPTY, TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
            {TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.CONSTRUCTION, TileType.EMPTY, TileType.CONSTRUCTION, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY},
            {TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.PARTICLES},
            {TileType.EMPTY, TileType.EMPTY, TileType.PARTICLES, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.EMPTY, TileType.ROCK},
    };

    @Override
    public TileType[][] getTerrainMapArray() {
        return TERRAIN_MAP;
    }

    @Override
    public TileType[][] getOverlayMapArray() {
        return OVERLAY_MAP;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else return other instanceof Desert;
    }

    @Override
    public int getStartRow() {
        return START_ROW;
    }

    @Override
    public int getStartCol() {
        return START_COL;
    }

    @Override
    public int getEndRow() {
        return END_ROW;
    }

    @Override
    public int getEndCol() {
        return END_COL;
    }
}
