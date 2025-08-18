package ir.ac.kntu.services.game.components.maps.renderers;

import ir.ac.kntu.services.game.components.tiles.TileType;
import ir.ac.kntu.services.game.components.tiles.factories.TileFactory;
import javafx.scene.Node;
import ir.ac.kntu.services.game.components.maps.Map;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GridMapRenderer implements MapRenderer {
    private final TileFactory tileFactory;

    private int mapRows;
    private int mapCols;

    public GridMapRenderer(TileFactory tileFactory) {
        this.tileFactory = tileFactory;
    }

    @Override
    public Node renderMap(Map map) {
        setMapDimensions(map);
        return renderLayer(map.getTerrainMapArray());
    }

    @Override
    public Node renderOverlay(Map map) {
        setMapDimensions(map);
        return renderLayer(map.getOverlayMapArray());
    }

    @Override
    public Image renderMapImage(Map map) {
        setMapDimensions(map);
        double tileSize = tileFactory.getTileSize();
        StackPane mapPane = new StackPane();
        mapPane.getChildren().addAll(renderMap(map), renderOverlay(map));
        mapPane.applyCss();
        mapPane.layout();
        WritableImage mapImage = new WritableImage((int) (mapCols * tileSize), (int) (mapRows * tileSize));
        mapPane.snapshot(null, mapImage);
        return mapImage;
    }

    @Override
    public int getMapRows() {
        return mapRows;
    }

    @Override
    public int getMapCols() {
        return mapCols;
    }

    private GridPane renderLayer(TileType[][] mapArray) {
        GridPane mapGrid = new GridPane();
        for (int row = 0; row < mapRows; row++) {
            for (int col = 0; col < mapCols; col++) {
                mapGrid.add(tileFactory.getTile(mapArray[row][col]).getImageView(), col, row);
            }
        }
        mapGrid.setSnapToPixel(false);
        return mapGrid;
    }

    private void setMapDimensions(Map map) {
        this.mapRows = map.getTerrainMapArray().length;
        this.mapCols = map.getTerrainMapArray()[0].length;
    }
}