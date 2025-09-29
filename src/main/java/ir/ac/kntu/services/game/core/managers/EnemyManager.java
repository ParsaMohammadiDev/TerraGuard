package ir.ac.kntu.services.game.core.managers;

import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.core.GameEngine;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;

import java.util.List;

public interface EnemyManager {
    void runEnemies(GameDifficulty difficulty, Map map, GameEngine gameEngine);
    void reachEnemy(Enemy enemy);
    void terminateEnemy(Enemy enemy);
    List<Enemy> getEnemies();
    void reset();
}