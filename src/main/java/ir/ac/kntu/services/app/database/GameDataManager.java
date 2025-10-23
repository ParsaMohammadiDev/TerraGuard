package ir.ac.kntu.services.app.database;

import ir.ac.kntu.services.game.components.maps.Map;

import java.util.List;

public interface GameDataManager {
    List<Map> loadMapsList();
}