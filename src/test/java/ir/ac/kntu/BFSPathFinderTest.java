package ir.ac.kntu;

import ir.ac.kntu.services.game.components.maps.GrassLand;
import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.components.pathfinders.BFSPathFinder;
import javafx.geometry.Point2D;
import org.junit.jupiter.api.Test;

public class BFSPathFinderTest {
    @Test
    public void testBFSPathFinder() {
        BFSPathFinder pathFinder = new BFSPathFinder();
        Map map = new GrassLand();
        for (Point2D point : pathFinder.generatePath(map, false)) {
            System.out.println(point);
        }
    }
}