package ir.ac.kntu.services.game.core.difficulties.publishers;

import ir.ac.kntu.services.game.core.difficulties.DifficultySubscriber;
import ir.ac.kntu.services.game.core.difficulties.GameDifficulty;
import ir.ac.kntu.services.game.core.difficulties.LevelSubscriber;
import java.util.ArrayList;
import java.util.List;

public class SimpleLevelPublisher implements LevelPublisher {
    private final List<LevelSubscriber> levelSubscribers = new ArrayList<>();
    private final List<DifficultySubscriber> difficultySubscribers = new ArrayList<>();

    @Override
    public void addSubscriber(LevelSubscriber subscriber) {
        levelSubscribers.add(subscriber);
    }

    @Override
    public void addSubscriber(DifficultySubscriber subscriber) {
        difficultySubscribers.add(subscriber);
    }

    @Override
    public void notifySubscribers(int level) {
        levelSubscribers.forEach(subscriber -> {subscriber.update(level);});
    }

    @Override
    public void notifySubscribers(GameDifficulty difficulty) {
        difficultySubscribers.forEach(subscriber -> {subscriber.update(difficulty);});
    }
}