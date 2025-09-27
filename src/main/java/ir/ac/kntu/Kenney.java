package ir.ac.kntu;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.animations.factories.SimpleAnimationFactory;
import ir.ac.kntu.services.app.database.DataManager;
import ir.ac.kntu.services.app.huds.factories.HUDFactory;
import ir.ac.kntu.services.app.huds.factories.SimpleHUDFactory;
import ir.ac.kntu.services.app.menus.factories.SimpleMenuFactory;
import ir.ac.kntu.services.app.menus.options.providers.MenuOptionProvider;
import ir.ac.kntu.services.app.menus.options.providers.SimpleMenuOptionProvider;
import ir.ac.kntu.services.app.scenes.managers.SceneManager;
import ir.ac.kntu.services.game.components.bullets.factories.BulletFactory;
import ir.ac.kntu.services.game.components.bullets.factories.SimpleBulletFactory;
import ir.ac.kntu.services.game.core.managers.BulletManager;
import ir.ac.kntu.services.game.core.managers.SimpleBulletManager;
import ir.ac.kntu.services.game.core.spawners.BulletRenderer;
import ir.ac.kntu.services.game.core.spawners.SimpleBulletRenderer;
import ir.ac.kntu.services.game.components.defenders.factories.DefenderFactory;
import ir.ac.kntu.services.game.components.defenders.factories.SimpleDefenderFactory;
import ir.ac.kntu.services.game.core.managers.DefenderManager;
import ir.ac.kntu.services.game.core.managers.SimpleDefenderManager;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.defenders.types.factories.DefenderTypeFactory;
import ir.ac.kntu.services.game.components.defenders.types.factories.FlyWeightDefenderTypeFactory;
import ir.ac.kntu.services.game.components.enemies.factories.EnemyFactory;
import ir.ac.kntu.services.game.components.enemies.factories.SimpleEnemyFactory;
import ir.ac.kntu.services.game.components.enemies.types.factories.EnemyTypeFactory;
import ir.ac.kntu.services.game.components.enemies.types.factories.FlyWeightEnemyTypeFactory;
import ir.ac.kntu.services.game.components.maps.renderers.GridMapRenderer;
import ir.ac.kntu.services.game.components.maps.renderers.MapRenderer;
import ir.ac.kntu.services.game.components.pathfinders.BFSPathFinder;
import ir.ac.kntu.services.game.components.pathfinders.PathFinder;
import ir.ac.kntu.services.game.components.tiles.factories.FlyWeightTileFactory;
import ir.ac.kntu.services.app.database.HardCodedDataManager;
import ir.ac.kntu.services.game.components.tiles.factories.TileFactory;
import ir.ac.kntu.services.game.components.tiles.states.providers.SimpleTileStateProvider;
import ir.ac.kntu.services.game.components.tiles.states.providers.TileStateProvider;
import ir.ac.kntu.services.game.components.wallets.CoinsWallet;
import ir.ac.kntu.services.game.components.wallets.Wallet;
import ir.ac.kntu.services.game.components.wallets.generators.AutoCoinGenerator;
import ir.ac.kntu.services.game.components.wallets.generators.CoinGenerator;
import ir.ac.kntu.services.game.components.wallets.mediators.SimpleWalletMediator;
import ir.ac.kntu.services.game.components.wallets.mediators.WalletMediator;
import ir.ac.kntu.services.game.components.wallets.publishers.SimpleWalletPublisher;
import ir.ac.kntu.services.game.components.wallets.publishers.WalletPublisher;
import ir.ac.kntu.services.game.core.GameEngine;
import ir.ac.kntu.services.game.core.KenneyGameEngine;
import ir.ac.kntu.services.game.core.difficulties.factories.DifficultyFactory;
import ir.ac.kntu.services.game.core.difficulties.factories.SimpleDifficultyFactory;
import ir.ac.kntu.services.app.scenes.factories.SceneFactory;
import ir.ac.kntu.services.app.scenes.factories.SimpleSceneFactory;
import ir.ac.kntu.services.app.scenes.managers.SimpleSceneManager;
import ir.ac.kntu.services.game.core.managers.EnemyManager;
import ir.ac.kntu.services.game.core.managers.SimpleEnemyManager;
import ir.ac.kntu.services.game.core.markets.KenneyMarket;
import ir.ac.kntu.services.game.core.markets.Market;
import ir.ac.kntu.services.game.core.spawners.EnemyRenderer;
import ir.ac.kntu.services.game.core.spawners.SimpleEnemyRenderer;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Kenney extends Application {
    private static final String APP_NAME = "Kenney";
    private static final String ICON_PATH = "/app/icon.png";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        setAppData(primaryStage);
        setServices(primaryStage).showIntro();
    }

    public void setAppData(Stage stage) {
        stage.setTitle(APP_NAME);
        stage.getIcons().add(new Image(ICON_PATH));
    }

    private SceneManager setServices(Stage primaryStage) {
        AnimationFactory animFactory = new SimpleAnimationFactory();
        DataManager dataManager = new HardCodedDataManager();
        EnemyTypeFactory enemyTypeFactory = new FlyWeightEnemyTypeFactory();
        DifficultyFactory difficultyFactory = new SimpleDifficultyFactory();
        WalletPublisher walletPublisher = new SimpleWalletPublisher();
        DefenderTypeFactory defenderTypeFactory = new FlyWeightDefenderTypeFactory();
        List<DefenderType> defenderTypes = new ArrayList<>();
        SimpleMenuFactory menuFactory = new SimpleMenuFactory();
        BulletFactory bulletFactory = new SimpleBulletFactory();
        BulletRenderer bulletRenderer = new SimpleBulletRenderer();

        defenderTypes.add(defenderTypeFactory.getFastTowerType());
        defenderTypes.add(defenderTypeFactory.getPowerfulTowerType());

        SceneManager sceneManager = new SimpleSceneManager(primaryStage);

        Wallet wallet = new CoinsWallet(walletPublisher);
        CoinGenerator coinGenerator = new AutoCoinGenerator(wallet);
        HUDFactory hudFactory = new SimpleHUDFactory(walletPublisher);
        WalletMediator walletMediator = new SimpleWalletMediator(wallet);
        Market market = new KenneyMarket(defenderTypes, walletPublisher, walletMediator);

        BulletManager bulletManager = new SimpleBulletManager(bulletFactory, bulletRenderer);
        DefenderFactory defenderFactory = new SimpleDefenderFactory(bulletManager);
        TileStateProvider tileStateProvider = new SimpleTileStateProvider(animFactory, menuFactory);
        TileFactory tileFactory = new FlyWeightTileFactory(animFactory, tileStateProvider);
        MapRenderer mapRenderer = new GridMapRenderer(tileFactory);
        EnemyRenderer enemyRenderer = new SimpleEnemyRenderer(mapRenderer, tileFactory);
        PathFinder pathFinder = new BFSPathFinder(tileFactory);
        EnemyFactory enemyFactory = new SimpleEnemyFactory(enemyTypeFactory, pathFinder);
        EnemyManager enemyManager = new SimpleEnemyManager(enemyFactory, enemyRenderer);
        DefenderManager defenderManager = new SimpleDefenderManager(tileStateProvider, defenderFactory, enemyRenderer.getEnemies());
        MenuOptionProvider menuOptionProvider = new SimpleMenuOptionProvider(defenderTypeFactory, market, animFactory, defenderManager);
        menuFactory.setOptionProvider(menuOptionProvider);

        GameEngine gameEngine = new KenneyGameEngine(
                mapRenderer,
                enemyRenderer,
                enemyManager,
                difficultyFactory,
                coinGenerator,
                sceneManager,
                wallet,
                bulletManager);

        SceneFactory sceneFactory = new SimpleSceneFactory(
                gameEngine,
                mapRenderer,
                difficultyFactory,
                sceneManager,
                dataManager,
                animFactory,
                hudFactory,
                menuFactory);

        sceneManager.setSceneFactory(sceneFactory);

        return sceneManager;
    }
}