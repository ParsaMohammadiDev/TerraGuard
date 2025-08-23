package ir.ac.kntu.services.game.core.markets;

import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.wallets.WalletSubscriber;
import ir.ac.kntu.services.game.components.wallets.publishers.WalletPublisher;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KenneyMarket implements Market, WalletSubscriber {
    private final Map<DefenderType, BooleanProperty> affordability = new HashMap<>();

    public KenneyMarket(List<DefenderType> defenderTypes, WalletPublisher walletPublisher) {
        defenderTypes.forEach(defenderType -> affordability.put(defenderType, new SimpleBooleanProperty(false)));
        walletPublisher.addSubscriber(this);
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
}