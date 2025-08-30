package ir.ac.kntu.services.game.components.wallets.mediators;

import ir.ac.kntu.services.game.components.wallets.Wallet;

public class SimpleWalletMediator implements WalletMediator {
    private final Wallet wallet;

    public SimpleWalletMediator(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public boolean requestWithdrawal(double amount) {
        return wallet.withdraw(amount);
    }
}
