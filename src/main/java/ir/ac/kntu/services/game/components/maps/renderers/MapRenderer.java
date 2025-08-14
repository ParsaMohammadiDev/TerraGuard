package ir.ac.kntu.services.game.components.maps.renderers;

import javafx.scene.Node;
import ir.ac.kntu.services.game.components.maps.Map;
import javafx.scene.image.Image;

public interface MapRenderer {
    Node renderMap(Map map);
    Image renderMapImage(Map map);
}