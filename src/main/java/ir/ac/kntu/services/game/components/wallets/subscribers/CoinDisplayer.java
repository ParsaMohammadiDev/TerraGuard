package ir.ac.kntu.services.game.components.wallets.subscribers;

import ir.ac.kntu.services.app.scenes.SceneElement;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class CoinDisplayer implements WalletSubscriber, SceneElement {
    private final Text coinText = new Text();
    @Override
    public void update(double amount) {
        coinText.setText(String.valueOf(amount));
    }

    @Override
    public Node getNode() {
        return coinText;
    }
}