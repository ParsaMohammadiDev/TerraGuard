package ir.ac.kntu.services.game.components.defenders;

import ir.ac.kntu.services.game.components.Entity;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.enemies.Enemy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import java.util.List;

public abstract class Defender implements Entity {
    private static final String DEFENDER_BASE_PATH = "/game/components/defenders/defender_base.png";
    private static final Image DEFENDER_BASE = new Image(DEFENDER_BASE_PATH);

    private final DefenderType defenderType;
    private final Pane defenderView;

    private double health;
    private double damageCoefficient;

    public Defender(DefenderType defenderType, double damageCoefficient) {
        this.defenderType = defenderType;
        this.damageCoefficient = damageCoefficient;
        defenderView = new StackPane();
        defenderView.getChildren().addAll(new ImageView(DEFENDER_BASE), getDefenderComposite());
    }

    public DefenderType getDefenderType() {
        return defenderType;
    }

    public abstract Pane getDefenderComposite();

    public abstract void activate(List<Enemy> enemies);

    @Override
    public Pane getView() {
        return defenderView;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void damage(double amount) {

    }
}