package ir.ac.kntu.services.game.components.maps;

import ir.ac.kntu.services.game.components.tiles.TileType;
import javafx.geometry.Point2D;

public interface Map {
    TileType[][] getTerrainMapArray();
    TileType[][] getOverlayMapArray();
    Point2D getStartPoint();
    Point2D getEndPoint();
}