package ir.ac.kntu.services.game.components.maps;

import ir.ac.kntu.services.game.components.tiles.TileType;
import javafx.geometry.Point2D;

public class Desert implements Map {
    private static final Point2D START_POINT = new Point2D(0, 5);
    private static final Point2D END_POINT = new Point2D(9, 4);

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
    public Point2D getStartPoint() {
        return START_POINT;
    }

    @Override
    public Point2D getEndPoint() {
        return END_POINT;
    }
}
