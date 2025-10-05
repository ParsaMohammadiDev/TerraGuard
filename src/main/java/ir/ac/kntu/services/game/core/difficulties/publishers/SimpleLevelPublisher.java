package ir.ac.kntu.services.game.core.difficulties.publishers;

import ir.ac.kntu.services.game.core.difficulties.LevelSubscriber;

import java.util.ArrayList;
import java.util.List;

public class SimpleLevelPublisher implements LevelPublisher {
    private final List<LevelSubscriber> subscribers = new ArrayList<LevelSubscriber>();

    @Override
    public void addSubscriber(LevelSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void notifySubscribers(int level) {
        subscribers.forEach(subscriber -> {subscriber.update(level);});
    }
}