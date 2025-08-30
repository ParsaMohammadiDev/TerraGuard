package ir.ac.kntu.services.game.components.wallets;

public interface Wallet {
    void charge(double amount);
    boolean withdraw(double amount);
    void reset();
}