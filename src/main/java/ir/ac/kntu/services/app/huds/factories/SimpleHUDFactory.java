package ir.ac.kntu.services.app.huds.factories;

import ir.ac.kntu.services.app.huds.CoinDisplayer;
import ir.ac.kntu.services.app.huds.HUD;
import ir.ac.kntu.services.game.components.wallets.WalletSubscriber;
import ir.ac.kntu.services.game.components.wallets.publishers.WalletPublisher;
import javafx.scene.Node;

public class SimpleHUDFactory implements HUDFactory {
    private final WalletPublisher walletPublisher;

    public SimpleHUDFactory(WalletPublisher walletPublisher) {
        this.walletPublisher = walletPublisher;
    }
    @Override
    public Node getCoinHUD() {
        HUD coinHUD = new CoinDisplayer();
        walletPublisher.addSubscriber((WalletSubscriber) coinHUD);
        return coinHUD.getNode();
    }
}