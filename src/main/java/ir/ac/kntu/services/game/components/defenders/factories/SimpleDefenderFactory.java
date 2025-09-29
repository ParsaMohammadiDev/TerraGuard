package ir.ac.kntu.services.game.components.defenders.factories;

import ir.ac.kntu.services.game.core.managers.BulletManager;
import ir.ac.kntu.services.game.components.defenders.Defender;
import ir.ac.kntu.services.game.components.defenders.FastTower;
import ir.ac.kntu.services.game.components.defenders.PowerfulTower;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.defenders.types.FastTowerType;
import ir.ac.kntu.services.game.components.defenders.types.PowerfulTowerType;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;
import ir.ac.kntu.services.game.core.managers.EnemyManager;
import ir.ac.kntu.services.game.core.strategies.EnemySelector;
import ir.ac.kntu.services.game.core.strategies.OldEnemySelector;

public class SimpleDefenderFactory implements DefenderFactory {
    private final BulletManager bulletManager;

    private final EnemySelector oldEnemySelector;

    public SimpleDefenderFactory(BulletManager bulletManager, EnemyManager enemyManager) {
        this.bulletManager = bulletManager;
        oldEnemySelector = new OldEnemySelector(enemyManager);
    }

    @Override
    public Defender getDefender(DefenderType defenderType, ClickableTile tile) {
        return createDefender(defenderType, tile);
    }

    private Defender createDefender(DefenderType defenderType, ClickableTile tile) {
        if(defenderType instanceof FastTowerType)
            return new FastTower(defenderType, bulletManager, tile, oldEnemySelector);
        if(defenderType instanceof PowerfulTowerType)
            return new PowerfulTower(defenderType, tile, bulletManager, oldEnemySelector);
        else
            throw new IllegalStateException("Unsupported defenderType");
    }
}