package ir.ac.kntu.components.maps.renderers;

import ir.ac.kntu.components.tiles.Tile;
import ir.ac.kntu.components.tiles.factories.TileFactory;
import javafx.geometry.Insets;
import javafx.scene.Node;
import ir.ac.kntu.components.maps.Map;
import javafx.scene.layout.GridPane;

public class GridMapRenderer implements MapRenderer {
    private static final int ROWS = 7;
    private static final int COLUMNS = 9;

    private TileFactory tileFactory;

    public GridMapRenderer(TileFactory tileFactory) {
        this.tileFactory = tileFactory;
    }

    @Override
    public Node renderMap(Map map) {
        GridPane mapGrid = new GridPane();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                Tile tile = tileFactory.getTile(map.getMapArray()[row][col]);
                mapGrid.add(tile.getImageView(), col, row);
            }
        }
        mapGrid.setSnapToPixel(false);
        return mapGrid;
    }
}