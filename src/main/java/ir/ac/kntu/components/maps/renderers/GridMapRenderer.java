package ir.ac.kntu.components.maps.renderers;

import ir.ac.kntu.components.tiles.TileType;
import ir.ac.kntu.components.tiles.factories.TileFactory;
import javafx.scene.Node;
import ir.ac.kntu.components.maps.Map;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GridMapRenderer implements MapRenderer {
    private static final int ROWS = 7;
    private static final int COLUMNS = 9;

    private TileFactory tileFactory;

    public GridMapRenderer(TileFactory tileFactory) {
        this.tileFactory = tileFactory;
    }

    @Override
    public Node renderMap(Map map) {
        StackPane mapPane = new StackPane();
        GridPane terrain = renderLayer(map.getTerrainMapArray());
        GridPane overlay = renderLayer(map.getOverlayMapArray());
        mapPane.getChildren().addAll(terrain, overlay);
        return mapPane;
    }

    private GridPane renderLayer(TileType[][] mapArray) {
        GridPane mapGrid = new GridPane();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                mapGrid.add(tileFactory.getTile(mapArray[row][col]).getImageView(), col, row);
            }
        }
        mapGrid.setSnapToPixel(false);
        return mapGrid;
    }
}