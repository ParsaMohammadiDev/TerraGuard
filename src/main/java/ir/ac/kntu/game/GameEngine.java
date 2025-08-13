package ir.ac.kntu.game;

import ir.ac.kntu.components.maps.Map;
import ir.ac.kntu.components.maps.renderers.MapRenderer;
import ir.ac.kntu.game.difficulties.GameDifficulty;
import javafx.scene.layout.Pane;

public interface GameEngine {
    Pane getGamePane();
    MapRenderer getMapRenderer();
    Map getGameMap();
    GameDifficulty getGameDifficulty();
    void setGameMap(Map map);
    void setGameDifficulty(GameDifficulty difficulty);
}