package ir.ac.kntu.services.game;

import ir.ac.kntu.services.game.components.enemies.factories.EnemyFactory;
import ir.ac.kntu.services.game.components.enemies.types.factories.EnemyTypeFactory;
import ir.ac.kntu.services.game.components.pathfinders.PathFinder;

public class KenneyEnemyServices implements EnemyServices {
    private EnemyTypeFactory enemyTypeFactory;
    private PathFinder pathFinder;
    private EnemyFactory enemyFactory;

    @Override
    public EnemyTypeFactory getEnemyTypeFactory() {
        return enemyTypeFactory;
    }

    @Override
    public PathFinder getPathFinder() {
        return pathFinder;
    }

    @Override
    public EnemyFactory getEnemyFactory() {
        return enemyFactory;
    }
}