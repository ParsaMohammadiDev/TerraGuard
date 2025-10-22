package ir.ac.kntu.services.game.core.markets;

import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.wallets.WalletSubscriber;
import ir.ac.kntu.services.game.components.wallets.mediators.WalletMediator;
import ir.ac.kntu.services.game.components.wallets.publishers.WalletPublisher;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TerraGuardMarket implements Market, WalletSubscriber {
    private final WalletMediator walletMediator;
    private final Map<DefenderType, BooleanProperty> affordability = new HashMap<>();

    public TerraGuardMarket(List<DefenderType> defenderTypes, WalletPublisher walletPublisher, WalletMediator walletMediator) {
        defenderTypes.forEach(defenderType -> affordability.put(defenderType, new SimpleBooleanProperty(false)));
        walletPublisher.addSubscriber(this);
        this.walletMediator = walletMediator;
    }

    @Override
    public void update(double balance) {
        affordability.forEach((defenderType, property) -> {
            property.set(defenderType.getPrice() <= balance);
        });
    }

    @Override
    public BooleanProperty isAffordable(DefenderType defenderType) {
        return affordability.get(defenderType);
    }

    @Override
    public boolean purchase(DefenderType defenderType) {
        return walletMediator.requestWithdrawal(defenderType.getPrice());
    }
}