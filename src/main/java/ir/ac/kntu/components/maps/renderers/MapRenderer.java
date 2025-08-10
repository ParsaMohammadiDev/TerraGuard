package ir.ac.kntu.components.maps.renderers;

import javafx.scene.Node;
import ir.ac.kntu.components.maps.Map;

public interface MapRenderer {
    Node renderMap(Map map);
}