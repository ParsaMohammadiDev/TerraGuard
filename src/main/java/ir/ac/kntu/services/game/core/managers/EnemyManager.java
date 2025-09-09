package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.core.GameEngine;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;

public interface EnemyManager {
    void runEnemies(GameDifficulty difficulty, Map map, GameEngine gameEngine);
    void reachEnemy();
}