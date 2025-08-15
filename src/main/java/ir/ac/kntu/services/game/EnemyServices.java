package ir.ac.kntu.services.game;

import ir.ac.kntu.services.game.components.enemies.factories.EnemyFactory;
import ir.ac.kntu.services.game.components.enemies.types.factories.EnemyTypeFactory;
import ir.ac.kntu.services.game.components.pathfinders.PathFinder;

public interface EnemyServices {
    EnemyTypeFactory getEnemyTypeFactory();
    PathFinder getPathFinder();
    EnemyFactory getEnemyFactory();
}