package ir.ac.kntu.services.app.huds.factories;

import javafx.scene.Node;

public interface HUDFactory {
    Node getCoinHUD();
    Node getLevelHUD();
    Node getDifficultyHUD();
}