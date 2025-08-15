package ir.ac.kntu.services.game.components.maps;

import ir.ac.kntu.services.game.components.tiles.TileType;
import javafx.geometry.Point2D;

public class GrassLand implements Map {
    private static final Point2D START_POINT = new Point2D(2, 0);
    private static final Point2D END_POINT = new Point2D(8, 0);

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

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else return other instanceof GrassLand;
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