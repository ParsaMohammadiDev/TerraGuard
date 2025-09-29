package ir.ac.kntu.services.game.components.defenders;

import ir.ac.kntu.services.game.components.bullets.BulletType;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;
import ir.ac.kntu.services.game.core.managers.BulletManager;
import ir.ac.kntu.services.game.core.strategies.EnemySelector;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PowerfulTower extends ShooterDefender{
    private static final double MUZZLE_LENGTH = 40.0; // in pixels
    private static final long SHOOTING_DELAY = 2;

    private final BulletType bulletType = BulletType.NORMAL_BULLET;
    private Pane powerfulTowerPane;

    public PowerfulTower(DefenderType defenderType, ClickableTile tile, BulletManager bulletManager, EnemySelector enemySelector) {
        super(defenderType, tile, bulletManager, enemySelector, SHOOTING_DELAY);
    }

    @Override
    public Pane getDefenderComposite() {
        powerfulTowerPane = new Pane();
        powerfulTowerPane.getChildren().add(new ImageView(getDefenderType().getImage()));
        return powerfulTowerPane;
    }

    @Override
    public BulletType getBulletType() {
        return bulletType;
    }

    @Override
    public Point2D getMuzzlePosition() {
        double x = getView().getLayoutX();
        double y = getView().getLayoutY();
        double rotation = powerfulTowerPane.getRotate() + 270;
        double muzzleX = x + (MUZZLE_LENGTH * Math.cos(Math.toRadians(rotation)));
        double muzzleY = y + (MUZZLE_LENGTH * Math.sin(Math.toRadians(rotation)));
        return new Point2D(muzzleX, muzzleY);
    }

    @Override
    public Node getMuzzleView() {
        return powerfulTowerPane;
    }

    @Override
    public double getShootingDelay() {
        return SHOOTING_DELAY;
    }
}