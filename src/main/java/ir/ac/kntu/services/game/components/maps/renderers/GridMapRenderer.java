package ir.ac.kntu.services.game.components.maps.renderers;

import ir.ac.kntu.services.game.GameServices;
import ir.ac.kntu.services.game.components.tiles.Tile;
import ir.ac.kntu.services.game.components.tiles.TileType;
import javafx.scene.Node;
import ir.ac.kntu.services.game.components.maps.Map;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GridMapRenderer implements MapRenderer {
    private static final int ROWS = 7;
    private static final int COLUMNS = 9;

    private GameServices gameServices;

    public GridMapRenderer(GameServices gameServices) {
        this.gameServices = gameServices;
    }

    @Override
    public Node renderMap(Map map) {
        return renderLayer(map.getTerrainMapArray());
    }

    @Override
    public Node renderOverlay(Map map) {
        return renderLayer(map.getOverlayMapArray());
    }

    @Override
    public Image renderMapImage(Map map) {
        StackPane mapPane = new StackPane();
        mapPane.getChildren().addAll(renderMap(map), renderOverlay(map));
        mapPane.applyCss();
        mapPane.layout();
        WritableImage mapImage = new WritableImage((int) (COLUMNS * Tile.getTileSize()), (int) (ROWS * Tile.getTileSize()));
        mapPane.snapshot(null, mapImage);
        return mapImage;
    }

    private GridPane renderLayer(TileType[][] mapArray) {
        GridPane mapGrid = new GridPane();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                mapGrid.add(gameServices.getTileFactory().getTile(mapArray[row][col]).getImageView(), col, row);
            }
        }
        mapGrid.setSnapToPixel(false);
        return mapGrid;
    }
}