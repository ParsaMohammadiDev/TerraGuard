package ir.ac.kntu.game;

import ir.ac.kntu.components.maps.Map;
import ir.ac.kntu.components.maps.renderers.MapRenderer;
import javafx.scene.layout.Pane;

public interface GameEngine {
    Pane getGamePane();
    MapRenderer getMapRenderer();
    void setGameMap(Map map);
    Map getGameMap();
}