package ir.ac.kntu.services.game.components.defenders;

import ir.ac.kntu.services.game.components.bullets.BulletType;
import ir.ac.kntu.services.game.core.managers.BulletManager;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;
import ir.ac.kntu.services.game.core.strategies.EnemySelector;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class FastTower extends ShooterDefender {
    private static final double MUZZLE_LENGTH = 40.0; // in pixels
    private static final long SHOOTING_DELAY = 1;

    private final BulletType bulletType = BulletType.FAST_BULLET;
    private Pane fastTowerPane;

    public FastTower(DefenderType defenderType, BulletManager bulletManager, ClickableTile tile, EnemySelector enemySelector) {
        super(defenderType, tile, bulletManager, enemySelector, SHOOTING_DELAY);
    }

    @Override
    public Pane getDefenderComposite() {
        fastTowerPane = new Pane();
        fastTowerPane.getChildren().add(new ImageView(getDefenderType().getImage()));
        return fastTowerPane;
    }

    @Override
    public BulletType getBulletType() {
        return bulletType;
    }

    @Override
    public Point2D getMuzzlePosition() {
        double x = getView().getLayoutX();
        double y = getView().getLayoutY();
        double rotation = fastTowerPane.getRotate() + 270;
        double muzzleX = x + (MUZZLE_LENGTH * Math.cos(Math.toRadians(rotation)));
        double muzzleY = y + (MUZZLE_LENGTH * Math.sin(Math.toRadians(rotation)));
        return new Point2D(muzzleX, muzzleY);
    }

    @Override
    public Node getMuzzleView() {
        return fastTowerPane;
    }

    @Override
    public double getShootingDelay() {
        return SHOOTING_DELAY;
    }
}
