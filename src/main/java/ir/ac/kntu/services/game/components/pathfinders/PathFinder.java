package ir.ac.kntu.services.game.components.pathfinders;

import ir.ac.kntu.services.game.components.maps.Map;
import javafx.geometry.Point2D;
import java.util.List;

public interface PathFinder {
    List<Point2D> generatePath(Map map, boolean randomized);
}