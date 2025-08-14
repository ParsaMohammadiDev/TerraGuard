package ir.ac.kntu.services.game;

import ir.ac.kntu.services.game.components.enemies.types.factories.EnemyTypeFactory;

public interface EnemyServices {
    EnemyTypeFactory getEnemyTypeFactory();
}