package ir.ac.kntu.services.game.core;

import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;
import javafx.scene.layout.Pane;

public interface GameEngine {
    Pane getGamePane();
    Map getGameMap();
    GameDifficulty getGameDifficulty();
    void setGameMap(Map map);
    void setGameDifficulty(GameDifficulty difficulty);
    void startGame();
}