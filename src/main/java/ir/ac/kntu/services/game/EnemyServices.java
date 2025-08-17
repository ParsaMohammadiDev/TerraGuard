package ir.ac.kntu.services.game;

import ir.ac.kntu.services.game.components.enemies.factories.EnemyFactory;
import ir.ac.kntu.services.game.components.enemies.types.factories.EnemyTypeFactory;
import ir.ac.kntu.services.game.components.pathfinders.PathFinder;
import ir.ac.kntu.services.game.core.managers.EnemyManager;
import ir.ac.kntu.services.game.core.spawners.EnemyRenderer;

public interface EnemyServices {
    EnemyTypeFactory getEnemyTypeFactory();
    PathFinder getPathFinder();
    EnemyFactory getEnemyFactory();
    EnemyRenderer getEnemyRenderer();
    EnemyManager getEnemyManager();
    void setEnemyTypeFactory(EnemyTypeFactory enemyTypeFactory);
    void setPathFinder(PathFinder pathFinder);
    void setEnemyFactory(EnemyFactory enemyFactory);
    void setEnemyRenderer(EnemyRenderer enemyRenderer);
    void setEnemyManager(EnemyManager enemyManager);
}