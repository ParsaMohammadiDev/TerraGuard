package ir.ac.kntu.services.game.components.enemies.factories;

import ir.ac.kntu.services.game.GameServices;
import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.components.enemies.Solider;

public class SimpleEnemyFactory implements EnemyFactory {
    private GameServices gameServices;

    public SimpleEnemyFactory(GameServices gameServices) {
        this.gameServices = gameServices;
    }

    @Override
    public Enemy getSolider() {
        return new Solider(
                gameServices.getEnemyServices().getEnemyTypeFactory().getSoliderType(),
                gameServices.getEnemyServices().getPathFinder().generatePath(
                        gameServices.getGameEngine().getGameMap(),
                        true
                )
        );
    }
}