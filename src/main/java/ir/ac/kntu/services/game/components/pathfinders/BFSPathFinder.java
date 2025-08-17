package ir.ac.kntu.services.game.components.pathfinders;

import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.components.tiles.Tile;
import ir.ac.kntu.services.game.components.tiles.TileType;
import javafx.geometry.Point2D;
import java.util.*;

public class BFSPathFinder implements PathFinder {
    private static final int[][] DIRECTIONS = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    private static final double MAX_JITTER = 15;

    @Override
    public List<Point2D> generatePath(Map map, boolean randomized) {
        List<Point2D> normalPath = getCenteredPath(getPurePath(findPath(map), map));
        if (randomized) {
            return getRandomizedPath(normalPath);
        }
        return normalPath;
    }

    private List<Point2D> getRandomizedPath(List<Point2D> path) {
        List<Point2D> randomizedPath = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            boolean horizontal = isHorizontal(path, i);
            double jitterX = horizontal ? 0 : (Math.random() * 2 - 1) * MAX_JITTER;
            double jitterY = horizontal ? (Math.random() * 2 - 1) * MAX_JITTER : 0;
            randomizedPath.add(new Point2D(
                    path.get(i).getX() + jitterX,
                    path.get(i).getY() + jitterY
            ));
        }
        return randomizedPath;
    }

    private boolean isHorizontal(List<Point2D> path, int idx) {
        Point2D p = path.get(idx);
        if (idx > 0) {
            Point2D prev = path.get(idx - 1);
            return prev.getY() == p.getY();
        } else if (idx < path.size() - 1) {
            Point2D next = path.get(idx + 1);
            return next.getY() == p.getY();
        }
        return false;
    }

    private List<Point2D> getCenteredPath(List<Point2D> purePath) {
        double tileSize = Tile.getTileSize();
        List<Point2D> centeredPath = new ArrayList<>();
        for (Point2D p : purePath) {
            double x = p.getX() * tileSize + tileSize / 4;
            double y = p.getY() * tileSize + tileSize / 4;
            centeredPath.add(new Point2D(x, y));
        }
        return centeredPath;
    }

    public List<Point2D> getPurePath(java.util.Map<Point2D, Point2D> trace, Map map) {
        List<Point2D> path = new ArrayList<>();
        Point2D step = new Point2D(map.getEndCol(), map.getEndRow());
        while (step != null) {
            path.add(step);
            step = trace.get(step);
        }
        Collections.reverse(path);
        return path;
    }

    public java.util.Map<Point2D, Point2D> findPath(Map map) {
        List<int[]> directions = getShuffledDirections();
        TileType[][] terrain = map.getTerrainMapArray();
        int rows = terrain.length;
        int cols = terrain[0].length;

        boolean[][] visited = new boolean[rows][cols];
        java.util.Map<Point2D, Point2D> trace = new HashMap<>();

        int startRow = map.getStartRow();
        int startCol = map.getStartCol();

        int endRow = map.getEndRow();
        int endCol = map.getEndCol();

        visited[startRow][startCol] = true;

        Queue<Point2D> queue = new LinkedList<>();
        Point2D startPoint = new Point2D(startCol, startRow);
        Point2D endPoint = new Point2D(endCol, endRow);
        queue.add(startPoint);

        while (!queue.isEmpty()) {
            Point2D cur = queue.poll();
            if (cur.equals(endPoint)) {
                break;
            }

            int curRow = (int) cur.getY();
            int curCol = (int) cur.getX();

            for (int[] direction : directions) {
                int newCol = curCol + direction[0];
                int newRow = curRow + direction[1];

                if (isPath(newRow, newCol, visited, terrain)) {
                    visited[newRow][newCol] = true;
                    Point2D neigh = new Point2D(newCol, newRow);
                    trace.put(neigh, cur);
                    queue.add(neigh);
                }
            }
        }
        return trace;
    }

    private boolean isPath(int row, int col, boolean[][] visited, TileType[][] terrain) {
        int rows = terrain.length;
        int cols = terrain[0].length;

        if (row < 0 || row >= rows) return false;
        if (col < 0 || col >= cols) return false;

        if (visited[row][col]) return false;
        return terrain[row][col] == TileType.ROAD;
    }

    private List<int[]> getShuffledDirections() {
        List<int[]> dirs = new ArrayList<>(Arrays.asList(DIRECTIONS));
        Collections.shuffle(dirs);
        return dirs;
    }
}