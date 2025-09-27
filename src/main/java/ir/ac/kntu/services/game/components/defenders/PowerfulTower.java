package ir.ac.kntu.services.game.components.defenders;

import ir.ac.kntu.services.game.components.bullets.BulletType;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;
import ir.ac.kntu.services.game.core.managers.BulletManager;
import ir.ac.kntu.services.game.core.strategies.OldEnemySelector;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PowerfulTower extends ShooterDefender{
    private static final double DAMAGE_COEFFICIENT = 2.5;
    private static final double MUZZLE_LENGTH = 40.0; // in pixels
    private static final long SHOOTING_DELAY = 2;

    private final BulletType bulletType = BulletType.NORMAL_BULLET;

    public PowerfulTower(DefenderType defenderType, ClickableTile tile, BulletManager bulletManager) {
        super(defenderType, DAMAGE_COEFFICIENT, tile, bulletManager, new OldEnemySelector(), SHOOTING_DELAY);
    }

    @Override
    public Pane getDefenderComposite() {
        Pane powerfulTower = new Pane();
        powerfulTower.getChildren().add(new ImageView(getDefenderType().getImage()));
        return powerfulTower;
    }

    @Override
    public BulletType getBulletType() {
        return bulletType;
    }

    @Override
    public Point2D getMuzzlePosition() {
        double x = getView().getLayoutX();
        double y = getView().getLayoutY();
        double rotation = getView().getRotate() + 90;
        double muzzleX = x + (MUZZLE_LENGTH * Math.cos(Math.toRadians(rotation)));
        double muzzleY = y + (MUZZLE_LENGTH * Math.sin(Math.toRadians(rotation)));
        return new Point2D(muzzleX, muzzleY);
    }
}