package ir.ac.kntu.services.game.components.enemies.factories;

import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.components.enemies.Solider;
import ir.ac.kntu.services.game.components.enemies.types.factories.EnemyTypeFactory;
import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.components.pathfinders.PathFinder;

public class SimpleEnemyFactory implements EnemyFactory {
    private final EnemyTypeFactory enemyTypeFactory;
    private final PathFinder pathFinder;

    public SimpleEnemyFactory(EnemyTypeFactory enemyTypeFactory, PathFinder pathFinder) {
        this.enemyTypeFactory = enemyTypeFactory;
        this.pathFinder = pathFinder;
    }

    @Override
    public Enemy getSolider(Map map) {
        return new Solider(
                enemyTypeFactory.getSoliderType(),
                pathFinder.generatePath(map, true)
        );
    }
}