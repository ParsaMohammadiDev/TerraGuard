package ir.ac.kntu.database;

import ir.ac.kntu.components.maps.Desert;
import ir.ac.kntu.components.maps.GrassLand;
import ir.ac.kntu.components.maps.Map;
import ir.ac.kntu.components.maps.StoneLand;
import java.util.ArrayList;
import java.util.List;

public class HardCodedDataManager implements DataManager {
    private final List<Map> mapsList;

    public HardCodedDataManager() {
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