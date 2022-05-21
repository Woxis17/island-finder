package com.woxis.island;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleIslandFinder implements IslandFinder {

  @Override
  public long countIslands(IslandMap islandMap) {
    Byte[][] map = islandMap.getMap();
    List<Island> islands = new ArrayList<>();
    for (int y = 0; y < islandMap.getY(); y++) {
      for (int x = 0; x < islandMap.getX(); x++) {
        if (map[y][x] == 1) {
          travelThePoint(x, y, islands);
        }
      }
    }
    return islands.size();
  }

  private void travelThePoint(int x, int y, List<Island> islands) {
    Point islandPoint = new Point(x, y);
    List<Island> adjacentIslands = islands.stream()
        .filter(island -> island.isPointAdjacent(islandPoint)).toList();

    if (adjacentIslands.isEmpty()) {
      Island newIsland = new Island();
      newIsland.addPoint(islandPoint);
      islands.add(newIsland);
    }

    if (adjacentIslands.size() == 1) {
      adjacentIslands.get(0).addPoint(islandPoint);
    }

    if (adjacentIslands.size() > 1) {
      Set<Point> mergedIslandPoints = adjacentIslands.stream()
          .flatMap(island -> island.getIslandPoints().stream())
          .collect(Collectors.toSet());
      mergedIslandPoints.add(islandPoint);

      adjacentIslands.forEach(islands::remove);
      Island mergedIsland = new Island(mergedIslandPoints);
      islands.add(mergedIsland);
    }
  }

}
