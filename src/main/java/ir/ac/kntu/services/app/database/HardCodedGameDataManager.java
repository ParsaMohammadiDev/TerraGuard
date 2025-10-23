package ir.ac.kntu.services.app.database;

import ir.ac.kntu.services.game.components.maps.Desert;
import ir.ac.kntu.services.game.components.maps.GrassLand;
import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.components.maps.StoneLand;
import java.util.ArrayList;
import java.util.List;

public class HardCodedGameDataManager implements GameDataManager {
    private final List<Map> mapsList;

    public HardCodedGameDataManager() {
        mapsList = new ArrayList<>();
        mapsList.add(new StoneLand());
        mapsList.add(new GrassLand());
        mapsList.add(new Desert());
    }
    @Override
    public List<Map> loadMapsList() {
        return mapsList;
    }
}