package ir.ac.kntu.services.game.components.enemies.factories;

import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.components.maps.Map;

public interface EnemyFactory {
    Enemy getSolider(Map map);
}
