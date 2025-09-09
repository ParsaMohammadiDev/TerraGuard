package ir.ac.kntu.services.game.components.wallets.generators;

import ir.ac.kntu.services.game.components.wallets.Wallet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AutoCoinGenerator implements CoinGenerator {
    private static final long GENERATION_DELAY = 2;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    private final Wallet wallet;

    private ScheduledExecutorService executor;

    public AutoCoinGenerator(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public void generate() {
        if (executor == null || executor.isShutdown() || executor.isTerminated()) {
            executor = Executors.newSingleThreadScheduledExecutor();
        }
        executor.scheduleWithFixedDelay(() -> wallet.charge(1), 0, GENERATION_DELAY, TIME_UNIT);
    }

    @Override
    public void stop() {
        executor.shutdownNow();
    }
}