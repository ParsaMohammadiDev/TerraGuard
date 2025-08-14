package ir.ac.kntu.services.game;

import ir.ac.kntu.services.game.components.enemies.types.factories.EnemyTypeFactory;

public class KenneyEnemyServices implements EnemyServices {
    private EnemyTypeFactory enemyTypeFactory;

    @Override
    public EnemyTypeFactory getEnemyTypeFactory() {
        return enemyTypeFactory;
    }
}
