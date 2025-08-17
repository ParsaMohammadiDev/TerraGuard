package ir.ac.kntu.services.game;

import ir.ac.kntu.services.game.components.enemies.factories.EnemyFactory;
import ir.ac.kntu.services.game.components.enemies.types.factories.EnemyTypeFactory;
import ir.ac.kntu.services.game.components.pathfinders.PathFinder;
import ir.ac.kntu.services.game.core.managers.EnemyManager;
import ir.ac.kntu.services.game.core.spawners.EnemyRenderer;

public class KenneyEnemyServices implements EnemyServices {
    private EnemyTypeFactory enemyTypeFactory;
    private PathFinder pathFinder;
    private EnemyFactory enemyFactory;
    private EnemyRenderer enemyRenderer;
    private EnemyManager enemyManager;

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

    @Override
    public EnemyRenderer getEnemyRenderer() {
        return enemyRenderer;
    }

    @Override
    public EnemyManager getEnemyManager() {
        return enemyManager;
    }

    @Override
    public void setEnemyTypeFactory(EnemyTypeFactory enemyTypeFactory) {
        this.enemyTypeFactory = enemyTypeFactory;
    }

    @Override
    public void setPathFinder(PathFinder pathFinder) {
        this.pathFinder = pathFinder;
    }

    @Override
    public void setEnemyFactory(EnemyFactory enemyFactory) {
        this.enemyFactory = enemyFactory;
    }

    @Override
    public void setEnemyRenderer(EnemyRenderer enemyRenderer) {
        this.enemyRenderer = enemyRenderer;
    }

    @Override
    public void setEnemyManager(EnemyManager enemyManager) {
        this.enemyManager = enemyManager;
    }
}