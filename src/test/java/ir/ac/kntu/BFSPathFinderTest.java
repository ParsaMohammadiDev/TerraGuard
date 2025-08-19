package ir.ac.kntu;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.animations.factories.SimpleAnimationFactory;
import ir.ac.kntu.services.game.components.maps.GrassLand;
import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.components.pathfinders.BFSPathFinder;
import ir.ac.kntu.services.game.components.pathfinders.PathFinder;
import ir.ac.kntu.services.game.components.tiles.factories.FlyWeightTileFactory;
import ir.ac.kntu.services.game.components.tiles.factories.TileFactory;
import javafx.geometry.Point2D;
import org.junit.jupiter.api.Test;

public class BFSPathFinderTest {
    @Test
    public void testBFSPathFinder() {
        AnimationFactory animFactory = new SimpleAnimationFactory();
        TileFactory tileFactory = new FlyWeightTileFactory(animFactory);
        Map map = new GrassLand();
        PathFinder pathFinder = new BFSPathFinder(tileFactory);
        for (Point2D point : pathFinder.generatePath(map, false)) {
            System.out.println(point);
        }
    }
}