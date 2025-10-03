package ir.ac.kntu.services.game.components.enemies.factories;

import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.core.GameEngine;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;

public interface EnemyFactory {
    Enemy getSolider(Map map);
    void setGameEngine(GameEngine gameEngine);
}