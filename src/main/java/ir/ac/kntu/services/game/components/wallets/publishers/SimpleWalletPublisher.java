package ir.ac.kntu.services.game.components.wallets.publishers;

import ir.ac.kntu.services.game.components.wallets.WalletSubscriber;
import java.util.ArrayList;
import java.util.List;

public class SimpleWalletPublisher implements WalletPublisher {
    private final List<WalletSubscriber> subscribers = new ArrayList<WalletSubscriber>();

    @Override
    public void addSubscriber(WalletSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void notifySubscribers(double balance) {
        subscribers.forEach(subscriber -> subscriber.update(balance));
    }
}