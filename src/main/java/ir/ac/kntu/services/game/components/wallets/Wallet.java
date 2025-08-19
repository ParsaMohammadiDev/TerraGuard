package ir.ac.kntu.services.game.components.wallets;

public interface Wallet {
    void charge(double amount);
    void withdraw(double amount);
}