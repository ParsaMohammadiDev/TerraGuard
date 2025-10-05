package ir.ac.kntu.services.game.core.difficulties.publishers;

import ir.ac.kntu.services.game.core.difficulties.DifficultySubscriber;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;
import ir.ac.kntu.services.game.core.difficulties.LevelSubscriber;

public interface LevelPublisher {
    void addSubscriber(LevelSubscriber subscriber);
    void addSubscriber(DifficultySubscriber subscriber);
    void notifySubscribers(int level);
    void notifySubscribers(GameDifficulty difficulty);
}