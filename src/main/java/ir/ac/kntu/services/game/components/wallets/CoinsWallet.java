package ir.ac.kntu.services.game.components.wallets;

import ir.ac.kntu.services.game.components.wallets.publishers.WalletPublisher;

public class CoinsWallet implements Wallet {
    private static final double STARTLING_BALANCE = 150;

    private final WalletPublisher walletPublisher;

    private double balance = STARTLING_BALANCE;

    public CoinsWallet(WalletPublisher walletPublisher) {
        this.walletPublisher = walletPublisher;
    }

    @Override
    public synchronized void charge(double amount) {
        balance += amount;
        walletPublisher.notifySubscribers(balance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        walletPublisher.notifySubscribers(balance);
    }

    @Override
    public void reset() {
        balance = STARTLING_BALANCE;
        walletPublisher.notifySubscribers(balance);
    }
}