package ir.ac.kntu.services.app.huds.factories;

import ir.ac.kntu.services.app.huds.CoinDisplayer;
import ir.ac.kntu.services.app.huds.DifficultyDisplayer;
import ir.ac.kntu.services.app.huds.HUD;
import ir.ac.kntu.services.app.huds.LevelDisplayer;
import ir.ac.kntu.services.game.components.wallets.publishers.WalletPublisher;
import ir.ac.kntu.services.game.core.difficulties.publishers.LevelPublisher;
import javafx.scene.Node;

public class SimpleHUDFactory implements HUDFactory {
    private final CoinDisplayer coinHUD;
    private final LevelDisplayer levelHUD;
    private final DifficultyDisplayer difficultyHUD;

    public SimpleHUDFactory(WalletPublisher walletPublisher, LevelPublisher levelPublisher) {
        coinHUD = new CoinDisplayer(walletPublisher);
        levelHUD = new LevelDisplayer(levelPublisher);
        difficultyHUD = new DifficultyDisplayer(levelPublisher);

    }

    @Override
    public Node getCoinHUD() {
        return coinHUD.getNode();
    }

    @Override
    public Node getLevelHUD() {
        return levelHUD.getNode();
    }

    @Override
    public Node getDifficultyHUD() {
        return difficultyHUD.getNode();
    }
}