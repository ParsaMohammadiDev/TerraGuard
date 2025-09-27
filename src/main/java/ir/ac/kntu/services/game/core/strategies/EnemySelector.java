package ir.ac.kntu.services.game.core.strategies;

import ir.ac.kntu.services.game.components.defenders.Defender;
import ir.ac.kntu.services.game.components.enemies.Enemy;

import java.util.List;

public interface EnemySelector {
    Enemy selectEnemy(List<Enemy> enemies, Defender defender);
}