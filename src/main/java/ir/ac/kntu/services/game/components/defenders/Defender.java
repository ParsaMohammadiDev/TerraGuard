package ir.ac.kntu.services.game.components.defenders;

import ir.ac.kntu.services.game.components.Entity;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.components.enemies.Enemy;
import ir.ac.kntu.services.game.components.tiles.ClickableTile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import java.util.List;

public abstract class Defender implements Entity {
    private static final String DEFENDER_BASE_PATH = "/game/components/defenders/defender_base.png";
    private static final Image DEFENDER_BASE = new Image(DEFENDER_BASE_PATH);

    private final DefenderType defenderType;
    private final StackPane defenderView;
    private final ClickableTile tile;

    private double health;
    private double damageCoefficient;

    public Defender(DefenderType defenderType, double damageCoefficient, ClickableTile tile) {
        this.defenderType = defenderType;
        this.damageCoefficient = damageCoefficient;
        this.tile = tile;
        defenderView = new StackPane();
        defenderView.getChildren().addAll(new ImageView(DEFENDER_BASE), getDefenderComposite());
    }

    public DefenderType getDefenderType() {
        return defenderType;
    }

    public abstract Pane getDefenderComposite();

    public abstract void activate(List<Enemy> enemies);

    @Override
    public Node getView() {
        return tile.getView();
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void damage(double amount) {

    }

    public Node getDefenderView() {
        return defenderView;
    }
}