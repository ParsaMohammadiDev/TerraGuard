package ir.ac.kntu.services.game.components.wallets.publishers;

import ir.ac.kntu.services.game.components.wallets.subscribers.WalletSubscriber;

public interface WalletPublisher {
    void notifySubscribers(double balance);
    void addSubscriber(WalletSubscriber subscriber);
}