package ir.ac.kntu.services.game.components.wallets;

import ir.ac.kntu.services.game.components.wallets.publishers.WalletPublisher;

public class CoinsWallet implements Wallet {
    private final WalletPublisher walletPublisher;

    private double balance;

    public CoinsWallet(final WalletPublisher walletPublisher) {
        this.walletPublisher = walletPublisher;
    }

    @Override
    public void charge(double amount) {
        balance += amount;
        walletPublisher.notifySubscribers(balance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        walletPublisher.notifySubscribers(balance);
    }
}