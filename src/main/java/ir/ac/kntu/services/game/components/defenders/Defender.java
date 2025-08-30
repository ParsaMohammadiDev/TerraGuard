package ir.ac.kntu.services.game.components.defenders;

import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public abstract class Defender {
    private static final String DEFENDER_BASE_PATH = "/game/components/defenders/defender_base.png";
    private static final Image DEFENDER_BASE = new Image(DEFENDER_BASE_PATH);

    private final DefenderType defenderType;
    private final StackPane defenderView;

    public Defender(DefenderType defenderType) {
        this.defenderType = defenderType;
        defenderView = new StackPane();
        defenderView.getChildren().addAll(new ImageView(DEFENDER_BASE), getDefenderComposite());
    }

    public Pane getView() {
        return defenderView;
    }

    public DefenderType getDefenderType() {
        return defenderType;
    }

    public abstract Pane getDefenderComposite();
}