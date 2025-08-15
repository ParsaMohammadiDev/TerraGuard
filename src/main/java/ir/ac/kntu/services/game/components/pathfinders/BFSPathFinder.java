package ir.ac.kntu.services.game.components.pathfinders;

import ir.ac.kntu.services.game.components.maps.Map;
import ir.ac.kntu.services.game.components.tiles.Tile;
import ir.ac.kntu.services.game.components.tiles.TileType;
import javafx.geometry.Point2D;
import java.util.*;

public class BFSPathFinder implements PathFinder {
    private static final int[][] DIRECTIONS = {
            {1, 0},
            {0, -1},
            {-1, 0},
            {0, 1},
    };
    private static final double MAX_JITTER = 5;

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
        for (int pointIndex = 0; pointIndex < path.size(); pointIndex++) {
            boolean horizontal = isHorizontal(path, path.get(pointIndex), pointIndex);
            double jitterX = horizontal ? 0 : (Math.random() * 2 - 1) * MAX_JITTER;
            double jitterY = horizontal ? (Math.random() * 2 - 1) * MAX_JITTER : 0;
            randomizedPath.add(new Point2D(path.get(pointIndex).getX() + jitterX, path.get(pointIndex).getY() + jitterY));
        }
        return randomizedPath;
    }

    private boolean isHorizontal(List<Point2D> path, Point2D point, int pointIndex) {
        if (pointIndex > 0) {
            Point2D prevPoint = path.get(pointIndex - 1);
            return prevPoint.getY() == point.getY();
        } else {
            Point2D nextPoint = path.get(pointIndex + 1);
            return nextPoint.getY() == point.getY();
        }
    }

    private List<Point2D> getCenteredPath(List<Point2D> purePath) {
        double tile_Size = Tile.getTileSize();
        List<Point2D> centeredPath = new ArrayList<>();
        for (Point2D point : purePath) {
            double x = point.getX() * tile_Size + tile_Size / 2;
            double y = point.getY() * tile_Size + tile_Size / 2;
            Point2D center = new Point2D(x, y);
            centeredPath.add(center);
        }
        return centeredPath;
    }

    private List<Point2D> getPurePath(java.util.Map<Point2D, Point2D> pointsTrace, Map map) {
        List<Point2D> path = new ArrayList<>();
        Point2D step = map.getEndPoint();
        while (step != null) {
            path.add(step);
            step = pointsTrace.get(step);
        }
        Collections.reverse(path);
        return path;
    }

    private java.util.Map<Point2D, Point2D> findPath(Map map) {
        List<int[]> directions = getShuffledDirections();
        TileType[][] terrainMap = map.getTerrainMapArray();
        int rows = terrainMap.length;
        int cols = terrainMap[0].length;
        boolean[][] visited = new boolean[rows][cols];
        java.util.Map<Point2D, Point2D> pointsTrace = new java.util.HashMap<>();
        Point2D startPoint = map.getStartPoint();
        Point2D endPoint = map.getEndPoint();
        visited[(int) (startPoint.getX())][(int) (startPoint.getY())] = true;
        Queue<Point2D> queue = new LinkedList<>();
        queue.add(startPoint);

        while (!queue.isEmpty()) {
            Point2D currentPoint = queue.poll();
            if (currentPoint.equals(endPoint)) {
                break;
            }

            for (int[] direction : directions) {
                int neighborX = (int) (currentPoint.getX()) + direction[0];
                int neighborY = (int) (currentPoint.getY()) + direction[1];
                if (isPath(neighborX, neighborY, visited, terrainMap)) {
                    visited[neighborX][neighborY] = true;
                    Point2D neighbor = new Point2D(neighborX, neighborY);
                    pointsTrace.put(neighbor, currentPoint);
                    queue.add(neighbor);
                }
            }
        }
        return pointsTrace;
    }

    private boolean isPath(int neighborX, int neighborY, boolean[][] visited, TileType[][] terrainMap) {
        int rows = visited.length;
        int cols = visited[0].length;

        if (!(neighborX >= 0 && neighborX < rows)) {
            return false;
        }
        if (!(neighborY >= 0 && neighborY < cols)) {
            return false;
        }
        if (visited[neighborX][neighborY]) {
            return false;
        }
        return terrainMap[neighborX][neighborY] == TileType.ROAD;
    }

    private List<int[]> getShuffledDirections() {
        List<int[]> directions = new ArrayList<>(Arrays.asList(DIRECTIONS));
        Collections.shuffle(directions);
        return directions;
    }
}