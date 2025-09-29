package ir.ac.kntu.services.game.core;

import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;
import javafx.scene.layout.Pane;

public interface GameEngine {
    Map getGameMap();
    GameDifficulty getGameDifficulty();
    void setGameMap(Map map);
    void setGameDifficulty(GameDifficulty difficulty);
    Pane startGame();
    void checkGameStatus(int initEnemyCount, int reachedEnemyCount, int terminatedEnemyCount);
}