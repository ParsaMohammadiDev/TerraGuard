package ir.ac.kntu.services.game.core.difficulties.publishers;

import ir.ac.kntu.services.game.core.difficulties.LevelSubscriber;

public interface LevelPublisher {
    void addSubscriber(LevelSubscriber subscriber);
    void notifySubscribers(int level);
}