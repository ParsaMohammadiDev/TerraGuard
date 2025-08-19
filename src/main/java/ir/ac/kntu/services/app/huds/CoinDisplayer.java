package ir.ac.kntu.services.app.huds;

import ir.ac.kntu.services.game.components.wallets.WalletSubscriber;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class CoinDisplayer implements WalletSubscriber, HUD {
    private final Text coinText = new Text();
    @Override
    public void update(double amount) {
        coinText.setText(String.valueOf((int) amount));
    }

    @Override
    public Node getNode() {
        return coinText;
    }
}